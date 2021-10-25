package com.chat.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ChatConsole {
	
	/*
 	 * 콘솔에서 메세지를 쓰기
 	 */
	public void writer(String message) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		String s = message;   //출력할 문자열
		bw.write(s+"\n");   //버퍼에 있는 값 전부 출력
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
	
	/*
	 * 서버 측에 메세지 내용 보내기
	 */
	public void sendMessage(String message) {
		
	}
}
