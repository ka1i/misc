from socket import *

host='127.0.0.1'
port=4180
buffersize=1024
addr=(host,port)

def tcp_server():
    server=socket(AF_INET,SOCK_STREAM)
    server.setsockopt(SOL_SOCKET,SO_REUSEADDR,1)
    try:
        server.bind(addr)
        server.listen(1)
        print("INFO: TCP Server {0}:{1} Listening Success...".format(host,port))
        return server
    except Exception as e:
        print(e)


if __name__=='__main__':
    print("欢迎使用多用途socket服务端")
    server=tcp_server()
    client_socket,client_info=server.accept()
    print("INFO: TCP Client {0}:{1} Connecting Success...".format(client_info[0],client_info[1]))
    confirm=client_socket.recv(buffersize)
    if(confirm.decode("utf-8")=="confirm"):
        client_socket.send("action".encode("utf-8"))
        print("INFO: 接受客户端服务请求")
        while True:

        	smess = input("请输入要发送的信息：")
        	client_socket.send(smess.encode("utf-8"))
        	print("来自对方傻逼的消息 :"+client_socket.recv(buffersize).decode("utf-8"))
    client_socket.close()
    server.close()
