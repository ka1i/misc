def Get_Filename():
	import win32ui
	dlg= win32ui.CreateFileDialog(1)# 1表示打开文件对话框
	dlg.SetOFNInitialDir('E:/')# 设置打开文件对话框中的初始显示目录
	dlg.DoModal()
	filename= dlg.GetPathName()
	return filename

	try:
		print("已选择文件：",end='')
		#print(Get_Filename())
		server=tcp_server()
		file=open("1.vsdx",'rb')
		while True:
			client_s,client_Info = server.accept()
			server.send("1.vsdx".encode("utf-8"))
			recvData = client_s.recv(buffsize)
			if((recvData.decode("utf-8"))=="start"):
				for temp_content in file.read(1024):
					content = file.read(1024)
					print("send: "+str(content))
					server.send(str(content).encode("utf-8"))
					
			if((recvData.decode("utf-8"))=="bye"):
				client.close()
				server.close()
			print("INFO---> %s -- %s"%(client_Info,recvData.decode("utf-8")))

		exit()
	except Exception as e:
		logging.error(e)
		print(e)