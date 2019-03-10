package com.hdtd.gui;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class JProcessBarDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JProgressBar processBar;
	private int maximum = 100;
	private int value = 0;

	public void setMaximum(int maximum) {
		this.maximum = maximum;
		processBar.setMaximum(maximum);
	}

	public void setValue(int value) {
		this.value = value;
		processBar.setValue(value);
		if (value == maximum) {
			processBar.setString("�������");// ������ʾ��Ϣ
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setVisible(false);
		}
	}

	public JProcessBarDemo() {
		setTitle("����"); // ���ô������

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô����˳��Ĳ���

		setBounds(100, 100, 350, 100);// ���ô����λ�úʹ�С
		this.setLocationRelativeTo(null); // ������ʾ

		JPanel contentPane = new JPanel(); // �����������

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �����������߿�

		setContentPane(contentPane);// Ӧ��(ʹ��)�������

		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));// ����Ϊ��ʽ����

		processBar = new JProgressBar();// ����������

		processBar.setStringPainted(true);// ���ý������ϵ��ַ�����ʾ��false������ʾ

		processBar.setBackground(Color.GREEN);

		contentPane.add(processBar);// �������ӽ��ȿؼ�

		processBar.setMaximum(this.maximum);
		
		processBar.setIndeterminate(true) ;
//		new Thread(){
//			public void run(){
//				
//			}
//		};
		// �����߳���ʾ����
		 new Thread(){
		
		 public void run(){
		 for (int i = 0; i < maximum; i++) {
		 try {
		 Thread.sleep(10); // �õ�ǰ�߳�����0.1ms
		 } catch (InterruptedException e) {
		 // TODO: handle exception
		 e.printStackTrace();
		 }
		 processBar.setValue(i); // ���ý�������ֵ
		 }
		 processBar.setString("�������");// ������ʾ��Ϣ
		 }
		 }.start(); // �����������߳�

		 contentPane.add(processBar);// �������ӽ��ȿؼ�
	}

	public static void main(String[] args) {
		JProcessBarDemo JPBD = new JProcessBarDemo();
		JPBD.setVisible(true);
//		JPBD.setMaximum(300);
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
//		for (int i = 0; i < 301; i++) {
//			try {
//				Thread.sleep(10); // �õ�ǰ�߳�����0.1ms
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			JPBD.setValue(i); // ���ý�������ֵ
//		}
	}
}
