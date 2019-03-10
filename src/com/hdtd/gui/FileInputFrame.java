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
	static String title = "  E文件解析";
	FileDialog fileDialog;
	File file;
	FileDialog directoryDialog;// 文件对话框
	JButton btn1;
	JButton btn2;
	JButton btn3;// 按钮
	JButton btn4;// 按钮
	// TextArea tarea;// 文本框
	JTextArea textArea = new JTextArea("");// 创建文本框;// 文本框

	JMenuBar menuBar = new JMenuBar(); // 创建菜单工具栏
	JMenu menu1 = new JMenu(" 文件    "); // 创建JMenu菜单对象
	JMenuItem menuItem11 = new JMenuItem("文件导入"); // 菜单项
	JMenuItem menuItem12 = new JMenuItem("文件夹导入");// 菜单项
	JMenuItem menuItem13 = new JMenuItem("清除选择");// 菜单项
	
	JMenu menu2 = new JMenu(" 帮助与关于 "); // 创建JMenu菜单对象
	JMenuItem menuItem21 = new JMenuItem("帮助   "); // 菜单项
	JMenuItem menuItem22 = new JMenuItem("关于   ");// 菜单项

	JMenu menu3 = new JMenu(" 数据库 "); // 创建JMenu菜单对象
	JMenuItem menuItem31 = new JMenuItem("数据库配置   "); // 菜单项
	
	public FileInputFrame() {
		super(title);// 标题
		init();
	}
	
	public static void reloadApplicationContext(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 初始化方法
	 */
	public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.setLayout(null);// 布局
		this.setBackground(Color.lightGray);// 背景色
		this.setSize(650, 360);// 设置大小
		this.setLocationRelativeTo(null); // 居中显示
		// setVisible(true);//设置可见
		btn1 = new JButton("文件导入");// 创建按钮
		btn2 = new JButton("目录导入");
		btn3 = new JButton("开始导入");
		btn4 = new JButton("退出");
		// tarea = new TextArea("");// 创建文本框
		add(btn1);// 添加按钮
		add(btn2);
		add(btn3);
		add(btn4);
		add(textArea);
		
		btn2.setEnabled(false);

		btn1.setBounds(520, 40, 90, 30);
		btn2.setBounds(520, 100, 90, 30);
		btn3.setBounds(520, 160, 90, 30);
		btn4.setBounds(520, 220, 90, 30);
		fileDialog = new FileDialog(this, "文件导入", FileDialog.LOAD);// 新建对话框
		directoryDialog = new FileDialog(this, "目录导入", FileDialog.LOAD);
		// sv = new FileDialog(this, "保存", FileDialog.SAVE);
		btn1.addActionListener(this);// 设置按钮点击监听事件
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		// 关闭事件处理
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);// 设置不可见
				System.exit(0);// 程序关闭
			}
		});

		// 菜单项目
		menu1.add(menuItem11); // 将菜单项目添加到菜单
		menu1.add(menuItem12); // 将菜单项目添加到菜单
		menu1.add(menuItem13); // 将菜单项目添加到菜单
		menuBar.add(menu1); // 将菜单增加到菜单工具栏

		menu3.add(menuItem31);
		menuBar.add(menu3);
		
		menu2.add(menuItem21); // 将菜单项目添加到菜单
		menu2.add(menuItem22); // 将菜单项目添加到菜单
		menuBar.add(menu2);

		this.setJMenuBar(menuBar); // 为 窗体设置 菜单工具栏
		
		this.setJMenuBar(menuBar); // 为 窗体设置 菜单工具栏

		menuAction(); // 菜单处理方法

		// **** 文本框相关设置
		textArea.setBounds(30, 40, 460, 220);// 设置文本框位置
		// 滚动条与自动换行
		JScrollPane scroll = new JScrollPane(textArea);
		// 把定义的JTextArea放到JScrollPane里面去
		scroll.setBounds(30, 40, 460, 220);

		// 分别设置水平和垂直滚动条总是出现
		// scroll.setHorizontalScrollBarPolicy(
		// JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		// 文本区光标设置
		textArea.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent mouseEvent) {
				textArea.setCursor(new Cursor(Cursor.TEXT_CURSOR)); // 鼠标进入Text区后变为文本输入指针
			}

			public void mouseExited(MouseEvent mouseEvent) {
				textArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 鼠标离开Text区后恢复默认形态
			}
		});
		textArea.getCaret().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textArea.getCaret().setVisible(true); // 使Text区的文本光标显示
			}
		});
		// 自动换行
		textArea.setLineWrap(true); // 激活自动换行功能
		textArea.setWrapStyleWord(true); // 激活断行不断字功能

		this.add(scroll);

		this.setVisible(true);// 设置可见
		
		
	}

	/**
	 * 菜单事件
	 */
	//TODO
	public void menuAction() {

		// 帮助按钮
		menuItem21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpAction();
			}

		});

		// 关于按钮
		menuItem22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), "北京华电通达科技有限公司\n      java开发组 \n  ", "关于",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		menuItem11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileDialog.setVisible(true);// 设置可见
				File singleFile = null;
				try {
					singleFile = new File(fileDialog.getDirectory(), fileDialog.getFile());// 打开文件
					
				} catch (NullPointerException e1) {// 如果有错误，这里进行处理
					// e1.printStackTrace();// 打印错误信息
					System.out.println("没有选择文件");
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

				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 设置只能选择目录
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String selectPath = chooser.getSelectedFile().getPath();

					System.out.println("你选择的目录是：" + selectPath);
					textArea.append("你选择的目录是：" + selectPath + "\n");
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
	 * 按钮事件处理
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn1) {// 按钮1事件处理
			fileDialog.setVisible(true);// 设置可见
			File singleFile = null;
			try {
				singleFile = new File(fileDialog.getDirectory(), fileDialog.getFile());// 打开文件
				
			} catch (NullPointerException e1) {// 如果有错误，这里进行处理
				// e1.printStackTrace();// 打印错误信息
				System.out.println("没有选择文件");
			}
			if(singleFile != null){
				this.btn1ActionHandler(singleFile);
			}
			
		}

		if (e.getSource() == btn2) {// 按钮2事件处理
			JFileChooser chooser = new JFileChooser();

			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 设置只能选择目录
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String selectPath = chooser.getSelectedFile().getPath();

				System.out.println("你选择的目录是：" + selectPath);
				textArea.append("你选择的目录是：" + selectPath + "\n");
				File directory = new File(selectPath);
				chooser.hide();
				
				this.btn2ActionHandler(directory);
			}
		}
		
		if (e.getSource() == btn3) {// 按钮3事件处理
			btn3ActionHandler();
		}

		if (e.getSource() == btn4) {// 按钮4事件处理
			int flag = JOptionPane.showConfirmDialog(new JFrame().getContentPane(), "确定要退出系统 ?", "系统信息", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			System.out.println(flag);
			if(flag == 0){
				System.exit(0);// 关闭程序
			}

//			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "请重新输入！", "系统信息",
//					JOptionPane.INFORMATION_MESSAGE);
//			System.out.println("sdddd");
		}

		
	}

	/**
	 * 显示帮助信息
	 */
	public void helpAction() {
		// 设置frame
		final JFrame helpFrame = new JFrame("帮助");
		helpFrame.setBounds(20, 20, 200, 200);
		helpFrame.setVisible(true);
		helpFrame.setLayout(null);// 布局
		helpFrame.setBackground(Color.lightGray);// 背景色
		helpFrame.setSize(650, 360);// 设置大小
		helpFrame.setLocationRelativeTo(null); // 居中显示

		// 设置textArea
		final JTextArea helpTextArea = new JTextArea();
		helpTextArea.setBounds(30, 40, 560, 200);// 设置文本框位置
		helpTextArea.setEditable(false);
		helpFrame.add(helpTextArea);

		// 滚动条与自动换行
		JScrollPane helpScroll = new JScrollPane(helpTextArea);
		// 把定义的JTextArea放到JScrollPane里面去
		helpScroll.setBounds(30, 40, 560, 200);

		// 分别设置水平和垂直滚动条总是出现
		// scroll.setHorizontalScrollBarPolicy(
		// JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		helpScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// 自动换行
		helpTextArea.setLineWrap(true); // 激活自动换行功能
		helpTextArea.setWrapStyleWord(true); // 激活断行不断字功能

		// 文本区光标设置
		helpTextArea.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent mouseEvent) {
				helpTextArea.setCursor(new Cursor(Cursor.TEXT_CURSOR)); // 鼠标进入Text区后变为文本输入指针
			}

			public void mouseExited(MouseEvent mouseEvent) {
				helpTextArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 鼠标离开Text区后恢复默认形态
			}
		});
		helpTextArea.getCaret().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				helpTextArea.getCaret().setVisible(true); // 使Text区的文本光标显示
			}
		});

		helpFrame.add(helpScroll);

		// 按钮
		JButton helpButton = new JButton("确定");
		// helpButton.setl
		helpButton.setBounds(270, 260, 90, 30);
		helpFrame.add(helpButton);

		// 关闭按钮
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				helpFrame.setVisible(false);
			}
		});

		// 读取帮助文件
		try {
			BufferedReader br = new BufferedReader(new FileReader("readme.help"));
			String line = null;
			while ((line = br.readLine()) != null) {
				helpTextArea.append(line + "\n");
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 设置光标从头显示
		helpTextArea.setSelectionStart(0);
		helpTextArea.setSelectionEnd(0);
	}
	
	/**
     * @param path 输入文件全路径
     * @return  返回文件名集合
     */
    public List<String> getFileNames(String path) {
    	List<String> fileNameList = new ArrayList<String>();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("路径 "+path + " 不存在");
            return null;
        }
        if(!file.isDirectory()){
        	System.out.println("路径 "+path + " 不是一个目录");
            return null;
        }
        
        File files[] = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isDirectory()) {
            	String fileName = f.getName();
//                System.out.println("[目录]: "+f.getName() );
                fileNameList.add("[目录]: "+f.getName());
            } else {
            	String fileName = f.getName();
//            	String fileName = f.getName().substring(0, f.getName().lastIndexOf("."));//获取文件名称，不带格式
//            	System.out.println("[文件]: "+fileName);
            	fileNameList.add("[文件]: "+fileName);
            }
        }
        return fileNameList;
    }
	
	
	//自定义事件1处理  文件处理
	public void btn1ActionHandler(File singleFile){
		//TODO
		textArea.append("您选择的文件： "+singleFile.getAbsolutePath()+"\n");
		if(singleFile.getName().toLowerCase().endsWith(".cime")){
			this.file = singleFile;
		}
		if(!singleFile.getName().toLowerCase().endsWith(".cime")){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "您选择的不是E文件，请重新选择", "系统信息",
					JOptionPane.WARNING_MESSAGE);
			System.out.println("不是E结尾的文件");
		}
	}
	
	
	//自定义事件2处理  文件夹处理
	public void btn2ActionHandler(File directory){
		//TODO
		textArea.append("您选择的目录为： "+directory.getAbsolutePath()+"\n");
		this.file = directory;
		
		List<String> fileNames = getFileNames(directory.getAbsolutePath());
		if(fileNames == null){
			textArea.append("您选择的目录下不存在文件或文件夹\n");
			return ;
		}
		textArea.append("目录下包含: \n");
		for (String string : fileNames) {
			textArea.append(string+"\n");
		}
		textArea.append("\n");
	}
	
	//自定义事件3处理  文件处理
	public void btn3ActionHandler(){
		//TODO
		if(this.file == null){
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "您还没有选择文件，请先选择文件或文件夹再继续次操作", "系统信息",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		//导入的是单个文件处理方式
		if(this.file.isFile()){
			textArea.append("文件\n ");
//			JProcessBarDemo JPBD = new JProcessBarDemo();
//			JPBD.setVisible(true);
//			JPBD.set
//			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			try {
//				final JProcessBarDemo JPBD = new JProcessBarDemo();
//				JPBD.setVisible(true);
				textArea.append("开始导入数据请耐心等待\n");
				EParseService service = new EParseService();
				service.parseEfile(context, file, textArea);
				textArea.append("文件导入成功\n");
				System.out.println("文件导入成功");
			} catch (Exception e) {
				textArea.append("文件导入异常，请检查后重新导入\n");
				System.out.println("文件导入异常");
				e.printStackTrace();
			}
		}
		//导入的是文件夹的处理方式
		if(this.file.isDirectory()){
			textArea.append("目录\n ");
		}
	}

	public static void main(String[] args) {
		FileInputFrame fileInputFrame = new FileInputFrame();
		
	}
}
