#!/bin/bash

function collect_one_pod_log() {
  namespace=$1
  pod_name=$2

  echo "------- collect logs of pod : " $pod_name " -------"
  echo date >"$folder/log.$pod_name.txt" >"$folder/describe.$pod_name.txt"
  kubectl logs -n $namespace $pod_name 2>/dev/null >>"$folder/log.$pod_name.txt"
  kubectl describe -n $namespace pod $pod_name 2>/dev/null >>"$folder/describe.$pod_name.txt"
  echo date >>"$folder/log.$pod_name.txt" >>"$folder/describe.$pod_name.txt"
  echo "------- collect logs of pod : " $pod_name " done -------"

}


function collect_pods_log(){
  namespace=$1
  kubectl get pods -n $namespace >"$folder/pods_name.txt"
  pods=(`kubectl get pods -n $namespace 2>/dev/null | grep "/" | awk '{printf $1 "\n"}'`)
  echo ${pods}
  for pod_name in "${pods[@]}";
  do
    collect_one_pod_log $namespace $pod_name
  done
}

function collect_logs(){
   create_folder
   collect_pods_log hb
}

function create_folder() {
  folder=${1:-$(date '+%F_%T_%N')}
  echo "create log folder : $folder"
  mkdir $folder
}


collect_logs
