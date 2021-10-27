package com.chat.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Program extends Thread{

	// 유저 확인
	static ArrayList<Socket> userList = new ArrayList<Socket>();
	static Socket socket;
				
	public Program(Socket socket) {
		this.socket = socket; // 유저 socket을 할당
		userList.add(socket); // 유저를 list에 추가
	}
	
	public void run() {
		try {
			System.out.println("[SERVER] Success Client Connected");
			System.out.println("[SERVER] Client IP:PORT :" + socket.getLocalSocketAddress());
				
			// InputStream - 클라이언트에서 보낸 메세지 읽기
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
						
			// OutputStream - 서버에서 클라이언트로 메세지 보내기
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
						
			// 클라이언트에게 연결되었다는 메세지 보내기
			pw.println("서버에 연결되었습니다! ID를 입력해 주세요!");
						
			String readValue; // Client에서 보낸 값 저장
			String name = null; // 클라이언트 이름 설정용
			boolean identify = false;
						
			// 클라이언트가 메세지 입력시마다 수행
			while((readValue = br.readLine()) != null ) {
				if(!identify) { // 연결 후 한번만 노출
					name = readValue; // 이름 할당
					identify = true;
					pw.println(name + "님이 접속하셨습니다.");
					continue;
				}
							
				// list 안에 클라이언트 정보가 담겨있음
				for(int i = 0; i<userList.size(); i++) { 
					os = userList.get(i).getOutputStream();
					pw = new PrintWriter(os, true);
					// 클라이언트에게 메세지 발송
					pw.println(name + " : " + readValue); 
				}			
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
				
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SERVER_PORT = 5022;
		
		try {
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				Thread th = new Program(socket);
				th.start();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
