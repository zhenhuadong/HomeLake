## 2. Create a pod name log, container name log-pro use image busybox. output the important information at /log/data/output.log. Then antoher container name log-cus use image busybox, load the output.log at /log/data/output.log and print it. Note, this log file only can be share within the pod.

Answer:

apiVersion: v1
kind: Pod
metadata:
  name: log
spec:
  containers:
  - image: busybox
    name: log-pro
    command: ["sh", "-c", "echo important information >>/log/data/output.log; sleep 1d"]
    volumeMounts:
    - name: data-log
      mountpath: /log/data
  - image: busybox
    name: log-cus
    command: ["sh", "-c", "cat /log/data/output.log; sleep 1d"]
    volumemounts:
    - name: data-log
      mountpath: /log/data
  volumes:
  - name: data-log
    emptyDir: {}

kubectl run log --image=busybox --dry-run=client -o yaml >log-pod.yaml

cat log-pod.yaml
apiVersion: v1
kind: Pod
metadata:
  creationTimestamp: null
  labels:
    run: log
  name: log
spec:
  containers:
  - image: busybox
    name: log
    resources: {}
  dnsPolicy: ClusterFirst
  restartPolicy: Always
status: {}




apiVersion: v1
kind: Pod
metadata:
  name: log
spec:
  containers:
  - image: busybox
    name: log-pro
    command: ["sh", "-c", "echo important information >> /log/data/output.log; sleep 1d"]
    volumeMounts:
    - name: data-log
      mountPath: /log/data
  - image: busybox
    name: log-cus
    command: ["sh", "-c", "cat /log/data/output.log; sleep 1d"]
    - name: data-log
      mountPath: /log/data
  volumes:
  - name: data-log
    emptyDir:{}