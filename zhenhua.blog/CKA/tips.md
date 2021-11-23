### 配置自动补全
    在当前Shell配置自动补全
    source <(kubectl completion bash)

    自动补全配置到bash启动脚本里
    echo "source <(kubectl completion bash)" >> ~/.bashrc

### 切换正确的cluster
    考题开始时候必须切换到正确的cluster上
    
    如下命令可以切换cluster
    kubectl config use-context k8s

    总共有7个cluster: k8s，hk8s，bk8s，wk8s，ek8s，mk8s，ok8s
