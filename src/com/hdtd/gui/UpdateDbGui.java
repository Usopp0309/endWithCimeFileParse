package com.hdtd.gui;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class UpdateDbGui {
	@Test
	public void testName() throws Exception {
		updateDbFrame();
	}
	public static void main(String[] args) {
		updateDbFrame();
	}
	public static void updateDbFrame() {
		
		// 设置frame
		final JFrame frame = new JFrame("数据库信息更改");
		frame.setBounds(20, 20, 200, 200);
		frame.setVisible(true);
		frame.setLayout(null);// 布局
		frame.setBackground(Color.lightGray);// 背景色
		frame.setSize(650, 360);// 设置大小
		frame.setLocationRelativeTo(null); // 居中显示
		
		// 按钮
		JButton ceshiBtn = new JButton("测试连接");
		ceshiBtn.setBounds(110, 220, 90, 30);
		frame.add(ceshiBtn);
		
		// 按钮
		final JButton yesBtn = new JButton("确定更改");
		yesBtn.setBounds(220, 220, 90, 30);
		frame.add(yesBtn);
		yesBtn.setEnabled(false);
		
		// 按钮
		JButton hideBtn = new JButton("取消更改");
		hideBtn.setBounds(330, 220, 90, 30);
		frame.add(hideBtn);
		
		final JTextField textField4 = new JTextField(30);
		textField4.setBounds(200, 10, 110, 30);
		textField4.setVisible(true);
		frame.add(textField4);
		
		final JTextField textField5 = new JTextField(30);
		textField5.setBounds(380, 10, 60, 30);
		textField5.setVisible(true);
		frame.add(textField5);
		
		final JTextField textField1 = new JTextField(30);
		textField1.setBounds(200, 40, 240, 30);
		textField1.setVisible(true);
		frame.add(textField1);
		
		final JTextField textField2 = new JTextField(30);
		textField2.setBounds(200, 100, 240, 30);
		textField2.setVisible(true);
		frame.add(textField2);
		
		final JTextField textField3 = new JTextField(30);
		textField3.setBounds(200, 160, 240, 30);
		textField3.setVisible(true);
		frame.add(textField3);
		
		JLabel jl4 = new JLabel("IP ：", SwingConstants.RIGHT);
		jl4.setFont(new Font("", 0, 16));
		jl4.setBounds(80, 10, 90, 30);
		frame.add(jl4);
		
		JLabel jl5 = new JLabel("端口 ：", SwingConstants.CENTER);
		jl5.setFont(new Font("", 0, 16));
		jl5.setBounds(320, 10, 60, 30);
		frame.add(jl5);
		
		JLabel jl1 = new JLabel("数据库名 ：", SwingConstants.CENTER);
		jl1.setFont(new Font("", 0, 16));
		jl1.setBounds(80, 40, 100, 30);
		frame.add(jl1);
		
		JLabel jl2 = new JLabel("用户名 ：", SwingConstants.CENTER);
		jl2.setFont(new Font("", 0, 16));
		jl2.setBounds(80, 100, 100, 30);
		frame.add(jl2);
		
		JLabel jl3 = new JLabel("密码 ：", SwingConstants.CENTER);
		jl3.setFont(new Font("", 0, 16));
		jl3.setBounds(80, 160, 100, 30);
		frame.add(jl3);
		
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("config/db.properties")));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		System.out.println(properties);

		String url = (String) properties.get("jdbc.url");
//		jdbc:mysql://localhost:3306/hdtdgfile?characterEncoding=utf-8
		String[] split = url.replace("jdbc:mysql://", "").split("/");
		String dbName = split[1];
		String[] ipAndPort = split[0].split(":");
		String ip = ipAndPort[0];
		String port = ipAndPort[1];
		
//		String dbName = url.replace("jdbc:mysql://localhost:3306/", "");
//		url = url.replace("?characterEncoding=utf-8", "");
		textField4.setText(ip);
		textField4.setFont(new Font("", 1, 14));
		
		textField5.setText(port);
		textField5.setFont(new Font("", 1, 14));
		
		textField1.setText(dbName);
		textField1.setFont(new Font("", 1, 14));
		
		String username = (String) properties.get("jdbc.username");
		textField2.setText(username);
		textField2.setFont(new Font("", 1, 14));
		
		String password = (String) properties.get("jdbc.password");
		textField3.setText(password);
		textField3.setFont(new Font("", 1, 14));
		
//		final String url2 = textField1.getText();
//		final String username2 = textField2.getText();
//		final String password2 = textField3.getText();
		
//		System.out.println(url2);
	
		// 关闭按钮
		hideBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		ceshiBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ip2 = textField4.getText();
				String port2 = textField5.getText();
				String dbName2 = textField1.getText();
				String url2 = "jdbc:mysql://"+ip2+":"+port2+"/" + dbName2;
				final String username2 = textField2.getText();
				final String password2 = textField3.getText();
				
				Connection conn=null;
				java.sql.PreparedStatement pst=null;
				ResultSet re=null;
				try {
					System.out.println(url2);
					System.out.println(username2);
					System.out.println(password2);
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection(url2, username2, password2);
					System.out.println("连接成功");
					yesBtn.setEnabled(true);
				} catch (Exception e2) {
					System.out.println("连接失败");
					yesBtn.setEnabled(false);
					e2.printStackTrace();
				}
				
			}
		});
		
		yesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ip2 = textField4.getText();
				String port2 = textField5.getText();
				String dbName2 = textField1.getText();
				String url2 = "jdbc:mysql://"+ip2+":"+port2+"/" + dbName2;
				final String username2 = textField2.getText();
				final String password2 = textField3.getText();
				try {
//					jdbc.driver=com.mysql.jdbc.Driver
//							jdbc.url=jdbc:mysql://localhost:3306/hdtdgfile?characterEncoding=utf-8
//							jdbc.username=root
//							jdbc.password=root
					System.err.println(url2);
					System.err.println(username2);
					System.err.println(password2);

					BufferedWriter bw = new BufferedWriter(new FileWriter(new File("config/db.properties")));
					bw.write("jdbc.driver=com.mysql.jdbc.Driver");
					bw.newLine();
//					bw.write("jdbc.url=jdbc:mysql://localhost:3306/" + url2 + "?characterEncoding=utf-8");
					bw.write("jdbc.url=" + url2 );
					bw.newLine();
					bw.write("jdbc.username=" + username2);
					System.out.println(username2);
					bw.newLine();
					bw.write("jdbc.password=" + password2);
					System.out.println(password2);
					bw.newLine();
					bw.flush();
					bw.close();
					FileInputFrame.reloadApplicationContext();	//重新加载context中数据库信息
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
}
