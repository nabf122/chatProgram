package com.chat.java;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientUI  extends JFrame{
	
	BufferedReader bw;
	PrintWriter pw;

	public ClientUI()
	{
		JTextArea textArea;
		JScrollPane scrollPane;
		JTextField textField;
		JButton btn1;
		
		this.setTitle("멀티 채팅 프로그램");
		this.setSize(449,649);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		// 텍스트 공간 만들기
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 430, 570);
		// 스크롤 만들기
		scrollPane = new JScrollPane(textArea);
		this.add(textArea);
		this.add(scrollPane);

		textField = new JTextField();
		textField.setBounds(0, 570, 370, 30);
		this.add(textField);
		       
		btn1 = new JButton("전송");
		btn1.setBounds(370, 570, 60, 30);
		this.add(btn1);
		
		this.setVisible(true);
		
		// 전송 버튼 클릭 이벤트
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()== btn1) {
					
					// 텍스트 필드 초기화
					textField.setText("");
				}
			}
		});
	}
}
