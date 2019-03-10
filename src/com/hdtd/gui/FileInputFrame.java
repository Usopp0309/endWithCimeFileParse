package com.hdtd.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdtd.service.EParseService;


public class FileInputFrame extends JFrame implements ActionListener {
	static ApplicationContext context = null;
	static String title = "  E�ļ�����";
	FileDialog fileDialog;
	File file;
	FileDialog directoryDialog;// �ļ��Ի���
	JButton btn1;
	JButton btn2;
	JButton btn3;// ��ť
	JButton btn4;// ��ť
	// TextArea tarea;// �ı���
	JTextArea textArea = new JTextArea("");// �����ı���;// �ı���

	JMenuBar menuBar = new JMenuBar(); // �����˵�������
	JMenu menu1 = new JMenu(" �ļ�    "); // ����JMenu�˵�����
	JMenuItem menuItem11 = new JMenuItem("�ļ�����"); // �˵���
	JMenuItem menuItem12 = new JMenuItem("�ļ��е���");// �˵���
	JMenuItem menuItem13 = new JMenuItem("���ѡ��");// �˵���
	
	JMenu menu2 = new JMenu(" ��������� "); // ����JMenu�˵�����
	JMenuItem menuItem21 = new JMenuItem("����   "); // �˵���
	JMenuItem menuItem22 = new JMenuItem("����   ");// �˵���

	JMenu menu3 = new JMenu(" ���ݿ� "); // ����JMenu�˵�����
	JMenuItem menuItem31 = new JMenuItem("���ݿ�����   "); // �˵���
	
	public FileInputFrame() {
		super(title);// ����
		init();
	}
	
	public static void reloadApplicationContext(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * ��ʼ������
	 */
	public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.setLayout(null);// ����
		this.setBackground(Color.lightGray);// ����ɫ
		this.setSize(650, 360);// ���ô�С
		this.setLocationRelativeTo(null); // ������ʾ
		// setVisible(true);//���ÿɼ�
		btn1 = new JButton("�ļ�����");// ������ť
		btn2 = new JButton("Ŀ¼����");
		btn3 = new JButton("��ʼ����");
		btn4 = new JButton("�˳�");
		// tarea = new TextArea("");// �����ı���
		add(btn1);// ��Ӱ�ť
		add(btn2);
		add(btn3);
		add(btn4);
		add(textArea);
		
		btn2.setEnabled(false);

		btn1.setBounds(520, 40, 90, 30);
		btn2.setBounds(520, 100, 90, 30);
		btn3.setBounds(520, 160, 90, 30);
		btn4.setBounds(520, 220, 90, 30);
		fileDialog = new FileDialog(this, "�ļ�����", FileDialog.LOAD);// �½��Ի���
		directoryDialog = new FileDialog(this, "Ŀ¼����", FileDialog.LOAD);
		// sv = new FileDialog(this, "����", FileDialog.SAVE);
		btn1.addActionListener(this);// ���ð�ť��������¼�
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		// �ر��¼�����
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);// ���ò��ɼ�
				System.exit(0);// ����ر�
			}
		});

		// �˵���Ŀ
		menu1.add(menuItem11); // ���˵���Ŀ��ӵ��˵�
		menu1.add(menuItem12); // ���˵���Ŀ��ӵ��˵�
		menu1.add(menuItem13); // ���˵���Ŀ��ӵ��˵�
		menuBar.add(menu1); // ���˵����ӵ��˵�������

		menu3.add(menuItem31);
		menuBar.add(menu3);
		
		menu2.add(menuItem21); // ���˵���Ŀ��ӵ��˵�
		menu2.add(menuItem22); // ���˵���Ŀ��ӵ��˵�
		menuBar.add(menu2);

		this.setJMenuBar(menuBar); // Ϊ �������� �˵�������
		
		this.setJMenuBar(menuBar); // Ϊ �������� �˵�������

		menuAction(); // �˵�������

		// **** �ı����������
		textArea.setBounds(30, 40, 460, 220);// �����ı���λ��
		// ���������Զ�����
		JScrollPane scroll = new JScrollPane(textArea);
		// �Ѷ����JTextArea�ŵ�JScrollPane����ȥ
		scroll.setBounds(30, 40, 460, 220);

		// �ֱ�����ˮƽ�ʹ�ֱ���������ǳ���
		// scroll.setHorizontalScrollBarPolicy(
		// JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		// �ı����������
		textArea.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent mouseEvent) {
				textArea.setCursor(new Cursor(Cursor.TEXT_CURSOR)); // ������Text�����Ϊ�ı�����ָ��
			}

			public void mouseExited(MouseEvent mouseEvent) {
				textArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����뿪Text����ָ�Ĭ����̬
			}
		});
		textArea.getCaret().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textArea.getCaret().setVisible(true); // ʹText�����ı������ʾ
			}
		});
		// �Զ�����
		textArea.setLineWrap(true); // �����Զ����й���
		textArea.setWrapStyleWord(true); // ������в����ֹ���

		this.add(scroll);

		this.setVisible(true);// ���ÿɼ�
		
		
	}

	/**
	 * �˵��¼�
	 */
	//TODO
	public void menuAction() {

		// ������ť
		menuItem21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpAction();
			}

		});

		// ���ڰ�ť
		menuItem22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), "��������ͨ��Ƽ����޹�˾\n      java������ \n  ", "����",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		menuItem11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDialog.setVisible(true);// ���ÿɼ�
				File singleFile = null;
				try {
					singleFile = new File(fileDialog.getDirectory(), fileDialog.getFile());// ���ļ�
					
				} catch (NullPointerException e1) {// ����д���������д���
					// e1.printStackTrace();// ��ӡ������Ϣ
					System.out.println("û��ѡ���ļ�");
				}
				if(singleFile != null){
					btn1ActionHandler(singleFile);
				}				
			}
		});
		
		menuItem12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();

				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// ����ֻ��ѡ��Ŀ¼
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String selectPath = chooser.getSelectedFile().getPath();

					System.out.println("��ѡ���Ŀ¼�ǣ�" + selectPath);
					textArea.append("��ѡ���Ŀ¼�ǣ�" + selectPath + "\n");
					File directory = new File(selectPath);
					chooser.hide();
					
					btn2ActionHandler(directory);
				}
			}
		});
		
		menuItem13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				file = null;
			}
		});
		
		menuItem31.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateDbGui updateDbGui = new UpdateDbGui();
				updateDbGui.updateDbFrame();
				
			}
		});

	}

	//TODO
	/**
	 * ��ť�¼�����
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn1) {// ��ť1�¼�����
			fileDialog.setVisible(true);// ���ÿɼ�
			File singleFile = null;
			try {
				singleFile = new File(fileDialog.getDirectory(), fileDialog.getFile());// ���ļ�
				
			} catch (NullPointerException e1) {// ����д���������д���
				// e1.printStackTrace();// ��ӡ������Ϣ
				System.out.println("û��ѡ���ļ�");
			}
			if(singleFile != null){
				this.btn1ActionHandler(singleFile);
			}
			
		}

		if (e.getSource() == btn2) {// ��ť2�¼�����
			JFileChooser chooser = new JFileChooser();

			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// ����ֻ��ѡ��Ŀ¼
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String selectPath = chooser.getSelectedFile().getPath();

				System.out.println("��ѡ���Ŀ¼�ǣ�" + selectPath);
				textArea.append("��ѡ���Ŀ¼�ǣ�" + selectPath + "\n");
				File directory = new File(selectPath);
				chooser.hide();
				
				this.btn2ActionHandler(directory);
			}
		}
		
		if (e.getSource() == btn3) {// ��ť3�¼�����
			btn3ActionHandler();
		}

		if (e.getSource() == btn4) {// ��ť4�¼�����
			int flag = JOptionPane.showConfirmDialog(new JFrame().getContentPane(), "ȷ��Ҫ�˳�ϵͳ ?", "ϵͳ��Ϣ", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			System.out.println(flag);
			if(flag == 0){
				System.exit(0);// �رճ���
			}

//			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "���������룡", "ϵͳ��Ϣ",
//					JOptionPane.INFORMATION_MESSAGE);
//			System.out.println("sdddd");
		}

		
	}

	/**
	 * ��ʾ������Ϣ
	 */
	public void helpAction() {
		// ����frame
		final JFrame helpFrame = new JFrame("����");
		helpFrame.setBounds(20, 20, 200, 200);
		helpFrame.setVisible(true);
		helpFrame.setLayout(null);// ����
		helpFrame.setBackground(Color.lightGray);// ����ɫ
		helpFrame.setSize(650, 360);// ���ô�С
		helpFrame.setLocationRelativeTo(null); // ������ʾ

		// ����textArea
		final JTextArea helpTextArea = new JTextArea();
		helpTextArea.setBounds(30, 40, 560, 200);// �����ı���λ��
		helpTextArea.setEditable(false);
		helpFrame.add(helpTextArea);

		// ���������Զ�����
		JScrollPane helpScroll = new JScrollPane(helpTextArea);
		// �Ѷ����JTextArea�ŵ�JScrollPane����ȥ
		helpScroll.setBounds(30, 40, 560, 200);

		// �ֱ�����ˮƽ�ʹ�ֱ���������ǳ���
		// scroll.setHorizontalScrollBarPolicy(
		// JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		helpScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// �Զ�����
		helpTextArea.setLineWrap(true); // �����Զ����й���
		helpTextArea.setWrapStyleWord(true); // ������в����ֹ���

		// �ı����������
		helpTextArea.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent mouseEvent) {
				helpTextArea.setCursor(new Cursor(Cursor.TEXT_CURSOR)); // ������Text�����Ϊ�ı�����ָ��
			}

			public void mouseExited(MouseEvent mouseEvent) {
				helpTextArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // ����뿪Text����ָ�Ĭ����̬
			}
		});
		helpTextArea.getCaret().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				helpTextArea.getCaret().setVisible(true); // ʹText�����ı������ʾ
			}
		});

		helpFrame.add(helpScroll);

		// ��ť
		JButton helpButton = new JButton("ȷ��");
		// helpButton.setl
		helpButton.setBounds(270, 260, 90, 30);
		helpFrame.add(helpButton);

		// �رհ�ť
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				helpFrame.setVisible(false);
			}
		});

		// ��ȡ�����ļ�
		try {
			BufferedReader br = new BufferedReader(new FileReader("readme.help"));
			String line = null;
			while ((line = br.readLine()) != null) {
				helpTextArea.append(line + "\n");
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// ���ù���ͷ��ʾ
		helpTextArea.setSelectionStart(0);
		helpTextArea.setSelectionEnd(0);
	}
	
	/**
     * @param path �����ļ�ȫ·��
     * @return  �����ļ�������
     */
    public List<String> getFileNames(String path) {
    	List<String> fileNameList = new ArrayList<String>();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("·�� "+path + " ������");
            return null;
        }
        if(!file.isDirectory()){
        	System.out.println("·�� "+path + " ����һ��Ŀ¼");
            return null;
        }
        
        File files[] = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isDirectory()) {
            	String fileName = f.getName();
//                System.out.println("[Ŀ¼]: "+f.getName() );
                fileNameList.add("[Ŀ¼]: "+f.getName());
            } else {
            	String fileName = f.getName();
//            	String fileName = f.getName().substring(0, f.getName().lastIndexOf("."));//��ȡ�ļ����ƣ�������ʽ
//            	System.out.println("[�ļ�]: "+fileName);
            	fileNameList.add("[�ļ�]: "+fileName);
            }
        }
        return fileNameList;
    }
	
	
	//�Զ����¼�1����  �ļ�����
	public void btn1ActionHandler(File singleFile){
		//TODO
		textArea.append("��ѡ����ļ��� "+singleFile.getAbsolutePath()+"\n");
		if(singleFile.getName().toLowerCase().endsWith(".cime")){
			this.file = singleFile;
		}
		if(!singleFile.getName().toLowerCase().endsWith(".cime")){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "��ѡ��Ĳ���E�ļ���������ѡ��", "ϵͳ��Ϣ",
					JOptionPane.WARNING_MESSAGE);
			System.out.println("����E��β���ļ�");
		}
	}
	
	
	//�Զ����¼�2����  �ļ��д���
	public void btn2ActionHandler(File directory){
		//TODO
		textArea.append("��ѡ���Ŀ¼Ϊ�� "+directory.getAbsolutePath()+"\n");
		this.file = directory;
		
		List<String> fileNames = getFileNames(directory.getAbsolutePath());
		if(fileNames == null){
			textArea.append("��ѡ���Ŀ¼�²������ļ����ļ���\n");
			return ;
		}
		textArea.append("Ŀ¼�°���: \n");
		for (String string : fileNames) {
			textArea.append(string+"\n");
		}
		textArea.append("\n");
	}
	
	//�Զ����¼�3����  �ļ�����
	public void btn3ActionHandler(){
		//TODO
		if(this.file == null){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "����û��ѡ���ļ�������ѡ���ļ����ļ����ټ����β���", "ϵͳ��Ϣ",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		//������ǵ����ļ�����ʽ
		if(this.file.isFile()){
			textArea.append("�ļ�\n ");
//			JProcessBarDemo JPBD = new JProcessBarDemo();
//			JPBD.setVisible(true);
//			JPBD.set
//			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			try {
//				final JProcessBarDemo JPBD = new JProcessBarDemo();
//				JPBD.setVisible(true);
				textArea.append("��ʼ�������������ĵȴ�\n");
				EParseService service = new EParseService();
				service.parseEfile(context, file, textArea);
				textArea.append("�ļ�����ɹ�\n");
				System.out.println("�ļ�����ɹ�");
			} catch (Exception e) {
				textArea.append("�ļ������쳣����������µ���\n");
				System.out.println("�ļ������쳣");
				e.printStackTrace();
			}
		}
		//��������ļ��еĴ���ʽ
		if(this.file.isDirectory()){
			textArea.append("Ŀ¼\n ");
		}
	}

	public static void main(String[] args) {
		FileInputFrame fileInputFrame = new FileInputFrame();
		
	}
}
