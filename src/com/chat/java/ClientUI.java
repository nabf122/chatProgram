package com.chat.java;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;

public class ClientUI  extends JFrame {

	public ClientUI()
	{
		this.setTitle("자바 채팅 프로그램 예제");
		this.setSize(400, 800);
		// 윈도우 닫을 때 실행도 종료하도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		con.add(new JTextArea(300, 300));
		con.add(new JTextField(200));
		con.add(new JButton("보내기"));
		
		this.setVisible(true);
	}
}
