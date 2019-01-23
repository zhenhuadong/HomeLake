#!/bin/bash



function monitor_pods_logs () {
  namespace=${1:"default"}
  pod_name=${2:"/"}
  interval=${3:"1"}

  while true; do
    clear
    date
    pods=`kubectl get pods -n $namespace 2>/dev/null | grep $pod_name | awk '{printf $1 }'`
    if [ ! -z "$pod_names" ]
    then
      for pod_names in "$pods"
        echo "------- pod name : " $pod_name " -------"
        kubectl logs -n $namespace $pod_name 2>/dev/null
      sleep 2
    else
      sleep 1
    fi
  done

}

monitor_pods_logs hb registry 2


