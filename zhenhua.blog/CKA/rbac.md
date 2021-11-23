# 管理基于角色的访问控制（RBAC

## 1. 
    Create a service account name dev-sa in default namespace, dev-sa can create below componenets in dev namespace:
    - Deployment
    - StatufulSet
    - DaemonSet

## Answer:
    source <(kubectl completion bash)
    echo "source <(kubectl completion bash)" >> ~/.bashrc

    kubectl config use-context k8s

    // 创建名为dev-sa的service account
    kubectl create sa dev-sa -n default

    // 给sa赋权: 创建Role和Rolebinding
    kubectl create role sa-role -n dev \
    --resource=deployment,statefulset,daemonset --verb=create

    kubectl create rolebinding sa-rolebinding -n dev 
    --role=sa-role --serviceaccount=default:dev-sa

    //验证是否成功
    kubectl auth can-i create deployment -n dev \
    --as=system:serviceaccount:default:dev-sa

openshift 平台上可以工作。

Rancher平台上碰到如下问题：
$ kubectl auth can-i create deployment -n dev --as=system:serviceaccount:default:dev-sa
Error from server (Forbidden): {"Code":{"Code":"Forbidden","Status":403},"Message":"clusters.management.cattle.io \"c-j5df8\" is forbidden: User \"system:serviceaccount:default:dev-sa\" cannot get resource \"clusters\" in API group \"management.cattle.io\" at the cluster scope","Cause":null,"FieldName":""} (post selfsubjectaccessreviews.authorization.k8s.io)


admin.conf是




