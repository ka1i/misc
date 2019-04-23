from socket import *

host='127.0.0.1'
port=4180
buffersize=1024

def tcp_client():
    client=socket(AF_INET,SOCK_STREAM)
    client.setsockopt(SOL_SOCKET,SO_REUSEADDR,1)
    try:
        client.connect((host,port))
        print("INFO: TCP Client {0}:{1} Connecting Success...".format(host,port))
        return client
    except Exception as e:
        print(e)

if __name__=='__main__':
    print("欢迎使用多用途socket客户端")
    client=tcp_client()
    client.send("confirm".encode("utf-8"))
    confirm=client.recv(buffersize)
    if(confirm.decode("utf-8")=="action"):
        print("INFO: 已确认服务，开始服务......")
        while True:
        	print("来自对方美眉的消息: "+client.recv(buffersize).decode("utf-8"))
        	smess = input("I send message: ")
        	client.send(smess.encode("utf-8"))
