CKA: Certified Kubernetes Administrator(CKA)

参考网址
- https://www.cncf.io/certification/cka/
- https://training.linuxfoundation.cn/certificates/1
- https://blog.csdn.net/shuoshuo132/article/details/115362867
- https://www.secrss.com/articles/34946



集群架构，安装和配置：25%
- 管理基于角色的访问控制（RBAC）
- 使用Kubeadm安装基本集群
- 管理高可用性的Kubernetes集群
- 设置基础架构以部署Kubernetes集群
- 使用Kubeadm在Kubernetes集群上执行版本升级
- 实施etcd备份和还原

工作负载和调度：15%
- 了解部署以及如何执行滚动更新和回滚
- 使用ConfigMaps和Secrets配置应用程序
- 了解如何扩展应用程序
- 了解用于创建健壮的、自修复的应用程序部署的原语
- 了解资源限制如何影响Pod调度
- 了解清单管理和通用模板工具

服务和网络：20%
- 了解集群节点上的主机网络配置
- 理解Pods之间的连通性
- 了解ClusterIP、NodePort、LoadBalancer服务类型和端点
- 了解如何使用入口控制器和入口资源
- 了解如何配置和使用CoreDNS
- 选择适当的容器网络接口插件

存储：10%
- 了解存储类、持久卷
- 了解卷模式、访问模式和卷回收策略
- 理解持久容量声明原语
- 了解如何配置具有持久性存储的应用程序

故障排除：30%
- 评估集群和节点日志
- 了解如何监视应用程序
- 管理容器标准输出和标准错误日志
- 解决应用程序故障
- 对群集组件故障进行故障排除
- 排除网络故障



# 考试环境介绍
考试环境一共 7 个 Cluster，为了尽量减少集群的切换已经对考题进行了分组，同一 Cluster 内的考题将会连续显示。

| 集群名称	| 集群规模 |
|-|-|
|k8s	| 1 master,2 worker| 
|hk8s	| 1 master,2 worker|
|bk8s	| 1 master,2 worker|
|wk8s	| 1 master,2 worker|
|ek8s	| 1 master,2 worker|
|mk8s	| 1 master,2 worker|
|ok8s	| 1 master,2 worker|



