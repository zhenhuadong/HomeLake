'''
Created on Sep 19, 2018

@author: ezhendo
'''

import requests

url="https://reqres.in/"

def demo_get():
    print("demo_get")
    r = requests.get(url+"api/users?page=2")
    print(vars(r.request))
    print(r)
    print(vars(r))
    #print(r.content)
    #print(r.json())
    #print("\n ".join(str(item) for item in vars(r).items()))
    r.raise_for_status

def demo_post():
    print("demo_post")
    dict_payload={ "name": "morpheus","job": "leader"}
    r = requests.post(url+"api/users", data=dict_payload)
    print(vars(r.request))
    print(r)
    print(vars(r))
    #print(r.content)
    #print(r.json())
    #print("\n ".join(str(item) for item in vars(r).items()))
    r.raise_for_status
    
def demo_delete():
    print("demo_delete")
    r = requests.delete(url + "api/users/2")
    print(vars(r.request))
    print(r)
    print(vars(r))
    #print("\n ".join(str(item) for item in vars(r).items()))
    r.raise_for_status
def demo_put():
    print("demo_put")
    dict_payload={"name": "morpheus", "job": "zion resident"}
    r = requests.put(url + "api/users/2", json=dict_payload)
    print(vars(r.request))
    print(r)
    print(vars(r))
    print(r.content)
    print(r.json())
    #print("\n ".join(str(item) for item in vars(r).items()))
    r.raise_for_status    

def demo_auth():
    pass

if __name__ == '__main__':
    demo_get()
    demo_post()
    demo_delete()
    demo_put()
    pass