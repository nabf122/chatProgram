package com.chat.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SERVER_PORT = 5022;
		
		try {
			// 1. 서버 소켓 객체 생성
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			
			while(true)
			{
				Socket socket = serverSocket.accept();
				System.out.println("[SERVER] Success Client Connected");
				System.out.println("[SERVER] Client IP:PORT :" + socket.getLocalSocketAddress());
				
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
