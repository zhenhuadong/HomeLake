'''
Created on Sep 19, 2018

@author: ezhendo
'''

import requests

url="https://reqres.in/"
geturl=url+"api/users?page=2"
posturl=url+"api/users"
deleteurl=url + "api/users/2"
puturl=url + "api/users/2"

def demo_get():
    print("demo_get")
    r = requests.get(geturl)
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
    r = requests.post(posturl, data=dict_payload)
    print(vars(r.request))
    print(r)
    print(vars(r))
    #print(r.content)
    #print(r.json())
    #print("\n ".join(str(item) for item in vars(r).items()))
    r.raise_for_status
    
def demo_delete():
    print("demo_delete")
    r = requests.delete(deleteurl)
    print(vars(r.request))
    print(r)
    print(vars(r))
    #print("\n ".join(str(item) for item in vars(r).items()))
    r.raise_for_status
def demo_put():
    print("demo_put")
    dict_payload={"name": "morpheus", "job": "zion resident"}
    r = requests.put(puturl, json=dict_payload)
    print(vars(r.request))
    print(r)
    print(vars(r))
    print(r.content)
    print(r.json()['job'])
    #print("\n ".join(str(item) for item in vars(r).items()))
    r.raise_for_status    

def demo_head():
    print("demo_header")
    r = requests.head('http://github.com', allow_redirects=True)
    #r = requests.get('http://github.com', allow_redirects=False)
    print(vars(r.request))
    print(r)
    print(vars(r))
    print("\n ".join(str(item) for item in vars(r).items()))
    print(r.headers)
    #{'Status': '200 OK', 'Expect-CT': 'max-age=2592000, report-uri="https://api.github.com/_private/browser/errors"', 'X-Request-Id': '93ecbb98-daa0-455d-a739-866ced223581', 'X-XSS-Protection': '1; mode=block', 'Content-Security-Policy': "default-src 'none'; base-uri 'self'; block-all-mixed-content; connect-src 'self' uploads.github.com status.github.com collector.githubapp.com api.github.com www.google-analytics.com github-cloud.s3.amazonaws.com github-production-repository-file-5c1aeb.s3.amazonaws.com github-production-upload-manifest-file-7fdce7.s3.amazonaws.com github-production-user-asset-6210df.s3.amazonaws.com wss://live.github.com; font-src assets-cdn.github.com; form-action 'self' github.com gist.github.com; frame-ancestors 'none'; frame-src render.githubusercontent.com; img-src 'self' data: assets-cdn.github.com identicons.github.com collector.githubapp.com github-cloud.s3.amazonaws.com *.githubusercontent.com; manifest-src 'self'; media-src 'none'; script-src assets-cdn.github.com; style-src 'unsafe-inline' assets-cdn.github.com", 'X-Content-Type-Options': 'nosniff', 'X-Runtime-rack': '0.082260', 'Set-Cookie': 'has_recent_activity=1; path=/; expires=Thu, 20 Sep 2018 10:16:01 -0000, _octo=GH1.1.1750094556.1537434961; domain=.github.com; path=/; expires=Sun, 20 Sep 2020 09:16:01 -0000, logged_in=no; domain=.github.com; path=/; expires=Mon, 20 Sep 2038 09:16:01 -0000; secure; HttpOnly, _gh_sess=ZHNDbzNPRU9KNVZxZWo0aXc5TGRTMHFWR3hUaHdEWmRSYlhlNG1ESytnOWJRTkM4d2J5OVJhcUxrM0taS2hkbTBQNGIxQzc2SFBWb0pUaGlzZFk2QmtrdExyZlVSZVRvYXFOQlRFWDdtRWxGRGZJNC83YVEwRTFwOU9XVmpMVDdnK2NYbE1LdWd3WE1TNFhMVVhwVUNWMDhEbEdoRXBqUDY4MFZnNkwxdDJoNC92YnBoKzJsVHZZRGs0cEpNalJqLS10VVV5TEdjV0w3M0NIckh5aGZNMERRPT0%3D--b484cff68c4f4a7a972957d99fa50af46241c3b7; path=/; secure; HttpOnly', 'Strict-Transport-Security': 'max-age=31536000; includeSubdomains; preload', 'Vary': 'X-PJAX', 'Server': 'GitHub.com', 'X-GitHub-Request-Id': 'E2E6:2278:BB9720:16008C3:5BA36550', 'X-Runtime': '0.070187', 'Cache-Control': 'no-cache', 'Date': 'Thu, 20 Sep 2018 09:16:01 GMT', 'X-Frame-Options': 'deny', 'Referrer-Policy': 'origin-when-cross-origin, strict-origin-when-cross-origin', 'Content-Type': 'text/html; charset=utf-8', 'Content-Encoding': 'gzip'}
    #{'Content-length': '0', 'Location': 'https://github.com/'}
    r.raise_for_status    


def demo_auth():
    pass

if __name__ == '__main__':
    demo_get()
    demo_post()
    demo_delete()
    demo_put()
    demo_head()
    pass