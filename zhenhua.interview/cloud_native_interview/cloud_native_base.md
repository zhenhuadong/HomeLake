### 1.1 简述 Kubernetes 集群相关组件
- Kuberenetes 是一个支持自动部署、扩展和管理容器化应用的开源软件。
- k8s是容器编排的工具.
- k8s集群包括master节点和worker节点。
  - master节点上运行着api-server, scheduler, controller-manager, etcd。
  - worker节点上运行着kubelet, kube-proxy, docker等。
- k8s通过配置文件对k8s的各种对象（deployment/pod/pvc...)进行声明式管理。这些配置文件（一般是一组yaml文件, 或者chart)通过helm/kubectl等客户端写入api-server, 并最终存储在etcd中。
- k8s通过各种controller（replicaset, statefulset, daemonset...)来监控对象的状态，并将对象的状态迁移到声明的最终状态. 
- k8s作为容器编排工具，其sheduler会自动监控集群的资源分配和使用情况，并根据容器所申请的资源来自动调度容器到指定的worker上运行。
- k8s要支持容器的自动部署，就需要worker上的kubelet根据PodSpec的描述，来确保容器运行在该Pod内。 kubelet(cadvisor)还会监控容器的资源使用情况，并在必要时驱逐和重启容器. kubelet还会按照pod的探针配置，给容器定时发送各种探针消息。kubelet调用容器运行时创建pod中的容器。
- k8s CRI（container runtime interface)的容器运行时，比如containerd, docker CRI-O等。containerd 调用 runC 创建 namespace 隔离和 cgroup 资源限制。kubelet扮演grpc的client端，容器运行时扮演grpc的server端。容器运行时首先要创建sandbox, 然后才分别调用image和container来拉取image,并拉起容器。
- k8s CNI (https://www.jianshu.com/p/21765d6deeb4)
未完待续





### 1.2 image, container, overlayer之间的关系
container是image的运行时状态，它把image的各overlay2层merge到一起，并增加一层：writeable layer.


image是有 image元数据，layer元数据 和 layer数据组成。 
- image的元数据：imagedb
    - /var/lib/docker/image/overlay2/imagedb/content/sha256/<image Id>
    - 其中的RootFS.Layers中有layer元数据的sha256值
    - 该目录下image Id的数目和当前Worker上的image是一样的
- layer的元数据：layerdb
    - /var/lib/docker/image/overlay2/layerdb/sha256/
    - 是以chain的方式从最底层关联到最上层的。
      - 公式：chainID=sha256sum(H(chainID) diffid)
    - /var/lib/docker/image/overlay2/layerdb/sha256/<chainID>/chach-id中存的是数据的实际地址
- layer数据：
    /var/lib/docker/overlay2/<layer id>

#### image的垃圾回收 和 容器的回收：

- docker删除垃圾镜像
注意，该方法在云平台不建议使用
sudo docker prune -a #可以删除所有没有container引用的image和layer

- kubelet删除垃圾镜像

    一般情况是kubelet每五分钟扫描一下未用的镜像，它通过imageManager和cadvisor监控磁盘使用率，超过85%就会触发镜像垃圾回收，从最老的未用image开始回收，一直到磁盘使用率低于80%。

    在kubelet 配置文件（--config=/var/lib/kubelet/config.yaml）中配置
    - imageMinimumGCAge            Default: "2m", 通常配置成0s
    - imageGCHighThresholdPercent  Default: 85
    - imageGCLowThresholdPercent   Default: 80

- kubelet删除垃圾（已死）容器
    一般情况下kubelet每分钟扫描一下已死的容器，
  - MinAge (--minimum-container-ttl-duration) 一般为0，随时可以垃圾收集
  - MaxPerPodContainer (--maximum-dead-containers-per-container)，一般为1，为了log -p
  - MaxContainers (--maximum-dead-containers), 一般为-1， 无限制



#### image的加速：

--image-pull-progress-deadline duration     Default: 1m0s


--eviction-hard、--eviction-soft 及 --eviction-minimum-reclaim


在worker上的image，通过image id, 可以找到对应的数据节点。
$ sudo docker inspect <imagename>:<tag> -f {{.Id}}
sha256:ddc69140ec844d53d9e8969f6751972f0e8a3f4ba619f9c9a9d09cb7399b798a

image metadata:
$ sudo cat /var/lib/docker/image/overlay2/imagedb/content/sha256/ddc69140ec844d53d9e8969f6751972f0e8a3f4ba619f9c9a9d09cb7399b798a |python -mjson.tool
    "rootfs": {
        "diff_ids": [
            "sha256:b6541a8ffdeb07e0b5f2af5160138adf2ae0e702429c9ae1b934c16a5bf31306",
            "sha256:4aa18f2b151c8cdf54f84003db553784200f9133de3309183a2c4b231d3ac8dc",
            "sha256:99a846cfd41a3bc671b9946837dc630f8e20b882c45e49387b15648c232903ce",
            "sha256:5d9ae9634d8c78e1483ac2d46b86558cc3652e6504b736697734a69eeb9b95f4",
            "sha256:23b334dcf75af0687874fcd8a1320755aa0a30a67b3e09cdbc3aa5939364a339"
        ],
        "type": "layers"
    }

$ sudo docker inspect <imagename>:<tag> -f {{.RootFS.Layers}}
[sha256:b6541a8ffdeb07e0b5f2af5160138adf2ae0e702429c9ae1b934c16a5bf31306 sha256:4aa18f2b151c8cdf54f84003db553784200f9133de3309183a2c4b231d3ac8dc sha256:99a846cfd41a3bc671b9946837dc630f8e20b882c45e49387b15648c232903ce sha256:5d9ae9634d8c78e1483ac2d46b86558cc3652e6504b736697734a69eeb9b95f4 sha256:23b334dcf75af0687874fcd8a1320755aa0a30a67b3e09cdbc3aa5939364a339]

layer metadata:
chainID=sha256sum(H(chainID) diffid)

第一层，最底层：chainID=diffId
diffId=sha256:b6541a8ffdeb07e0b5f2af5160138adf2ae0e702429c9ae1b934c16a5bf31306
/var/lib/docker/image/overlay2/layerdb/sha256/b6541a8ffdeb07e0b5f2af5160138adf2ae0e702429c9ae1b934c16a5bf31306

第二层：chainID=sha256sum(H(chainID) diffid)
/var/lib/docker/image/overlay2/layerdb/sha256/1706e4ba31fe5c0db135f5ed5fe53a3f7952150e213f3aa1f03dbef7a9bb6927

第三层：chainID=sha256sum(H(chainID) diffid)
diffId=sha256:99a846cfd41a3bc671b9946837dc630f8e20b882c45e49387b15648c232903ce
H(chainId)=sha256:1706e4ba31fe5c0db135f5ed5fe53a3f7952150e213f3aa1f03dbef7a9bb6927
echo -n 'sha256:1706e4ba31fe5c0db135f5ed5fe53a3f7952150e213f3aa1f03dbef7a9bb6927 sha256:99a846cfd41a3bc671b9946837dc630f8e20b882c45e49387b15648c232903ce' |sha256sum
ddde46059c9972e0c61baabbe59c8ad0dc12ab3c9469dbc14dfa3e35d4930ea9  -
/var/lib/docker/image/overlay2/layerdb/sha256/ddde46059c9972e0c61baabbe59c8ad0dc12ab3c9469dbc14dfa3e35d4930ea9

第四层：chainID=sha256sum(H(chainID) diffid)
/var/lib/docker/image/overlay2/layerdb/sha256/4623acae1c1aeac725f045e7693dd88b314021b76f81d95d08f6483380c8adc3

第五层：chainID=sha256sum(H(chainID) diffid)
/var/lib/docker/image/overlay2/layerdb/sha256/3ba0aca5677937a1efbd98889cb4e0d6c2659251491760848fe0d4fa591dff9c

layer data:
sudo cat /var/lib/docker/image/overlay2/layerdb/sha256/<layer_chainID>/cache-id 可以找到layer数据地址
/var/lib/docker/overlay2/22002bc7a0ff73a594232e59db4e8035704f43c569700bf0c5c754d6457e1035
/var/lib/docker/overlay2/4e9e41b031e1b91a8427430d9ab1861fe03701e8289116fe9cb29ba1102c57e5
/var/lib/docker/overlay2/6ba69c54529c6f0bcebee78df2f2dea708d87e0cf090a83cefc01fb5a919fbc1
/var/lib/docker/overlay2/470ea56c2fafa5edfbb1c251a62fe3cc6e610937f03340aa91babd1487845821
/var/lib/docker/overlay2/494fbc1767fbc69e8352b98dcab06585374f238657cb6cef7b798157ef029093






### 1.3 CNI，CRI，CSI分别是什么
- CRI（Container Runtime Interface）：容器运行时接口，提供计算资源
- CNI（Container Network Interface）：容器网络接口，提供网络资源
- CSI（Container Storage Interface）：容器存储接口，提供存储资源

#### CRI
kubelet内置grpc的client, 与ContainerRuntime的CRI shim也就是grpc的server通信。protocol buff API 包括两个grpc服务，imageService和runtimeService. 

imageService负责从image仓库拉取，检查，删除image. 

runtimeService负责管理pod和container的生命周期，以及与container的交互调用（exec/attach/port-forward). Sandbox相关的API代表着对Pod的操作， container相关的API代表对container的操作。

#### 创建一个pod的过程



Pending： api server创建了Pod；没有Resource就会一直这种状态
Creating: shceduler为pod指定workerNode； pull image失败就会一直处于这种状态
Running: 
Crashloop Back: 





#### CNI
https://www.cnblogs.com/goldsunshine/p/10701242.html