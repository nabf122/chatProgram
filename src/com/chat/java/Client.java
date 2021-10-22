package com.chat.java;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws IOException {
		final int CONN_PORT = 5022;
		final String CONN_IP = "59.5.20.46";
		
		Socket socket = new Socket(CONN_IP, CONN_PORT);
		System.out.println("[Client] 서버 접속 완료");
		
		new ClientUI();
		
		while(true)
		{
			
		}
	}
}