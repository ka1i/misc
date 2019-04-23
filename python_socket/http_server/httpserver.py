#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
Time    :2019/4/10 下午 7:54
Auther  :Mardan
Web     :https://github.com/ka1i
Version :python 3.7.6
'''

import os
import sys
from socket import *

host='0.0.0.0'
port=8888
recv_buffer=1024

index_context='''
HTTP/1.x 200 ok
Content-Type: text/html

'''

html_context=open('index.html','r')
index_context+=html_context.read()
html_context.close()

assets_html=open('test.jpg','rb')
assets_content=b'''
HTTP/1.x 200 ok
Content-Type: image/jpg

'''
assets_content+=assets_html.read()
assets_html.close()


def tcp_server():
    server = socket(AF_INET, SOCK_STREAM)
    server.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)
    try:
        server.bind((host,port))
        server.listen(3)
        print("TCPServer {0}:{1} Listening Success...".format(host,port))
        return server
    except Exception as e:
        print(e)

if __name__ == '__main__':
    print('Welcome to the http server')
    server=tcp_server()
    while True:
        client_socket,client_info = server.accept()
        requests=client_socket.recv(recv_buffer)
        print("TCPClient {0}:{1} Connecting Success...".format(client_info[0],client_info[1]))
        print("Get {0}".format(((requests.decode('utf-8')).split("\r\n")[0])))
        #client_socket.send("Curl test".encode('utf-8'))
        print("send Message")
        client_socket.send(index_context.encode('utf-8'))
        print(requests)