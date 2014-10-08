/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmgnt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author Yarrow
 */
class Register_GUI{
    public RegisterFrame rf;
    public Register_GUI(){
        rf=new RegisterFrame();
	rf.setVisible(true);//使窗口可见
    }
}

public class RegisterFrame extends JFrame{
    private Toolkit tool;
    public RegisterFrame(){
	setTitle("用户注册");
	tool=Toolkit.getDefaultToolkit();//获取默认工具包
	Dimension ds=tool.getScreenSize();//dimention  封装了构件高宽的类
	int w=ds.width;
	int h=ds.height;
	setBounds((w-300)/3,(h-300)/3-50,300,400);//设置位置与大小     左上角X坐标、左上角Y坐标、长、宽
	setResizable(true);//false表示不能改变窗口大小
	RegisterPanel rp=new RegisterPanel();
	add(rp);
    }
}

class RegisterPanel extends JPanel implements ActionListener{   
//内部组件类
    private JLabel titlelabel,namelabel,pwdlabel1,pwdlabel2,sexlabel,agelabel,maillabel,phonelabel;//标签
    private JTextField namefield,agefield,mailfield,phonefield;//文本域
    private JPasswordField pwdfield1,pwdfield2;//密码域
    private JButton commitbtn,resetbtn,cancelbtn;//三个按钮注册、重置、返回
    private JRadioButton rbtn1,rbtn2;//单选按钮，选择性别
    private GridBagConstraints gbc;//布局
    private JPanel panel;//性别选择的panel
    private Box box;//三个button
    
    RegisterPanel(){		//构造方法
        //初始化标签与文本域
        Font font = new Font("微软雅黑", Font.BOLD,12 );
        UIManager.put("Label.font",font);
        UIManager.put("Button.font",font);
        UIManager.put("TextField.font",font);
	titlelabel=new JLabel("软件用户注册");
	titlelabel.setFont(new Font("微软雅黑",Font.BOLD,25));
	namelabel=new JLabel("用 户 名：");
	pwdlabel1=new JLabel("密     码：");
	pwdlabel2=new JLabel("确认密码：");
	sexlabel=new JLabel("性     别：");
	agelabel=new JLabel("  年    龄：");
	maillabel=new JLabel("电子邮箱：");
	phonelabel=new JLabel("手     机：");
	namefield=new JTextField(8);
        namefield.setText("请输入用户名");
        namefield.setForeground(Color.gray);
	pwdfield1=new JPasswordField(8);
	pwdfield1.setEchoChar('*');
	pwdfield2=new JPasswordField(8);
	pwdfield2.setEchoChar('*');
	mailfield=new JTextField(8);
        mailfield.setText("请输入Email地址");
        mailfield.setForeground(Color.gray);
	phonefield=new JTextField(8);
        phonefield.setText("请输入电话");
        phonefield.setForeground(Color.gray);
	agefield=new JTextField(4);     
	rbtn1=new JRadioButton("男");
        rbtn1.setFont(new Font("微软雅黑",Font.BOLD,12));
	rbtn2=new JRadioButton("女");
        rbtn2.setFont(new Font("微软雅黑",Font.BOLD,12));
	rbtn1.setSelected(true);
	ButtonGroup bg=new ButtonGroup();//ButtonGroup只是用来把radioButton绑在一起  使其在这个组中的只能点击一个
	bg.add(rbtn1);
	bg.add(rbtn2);
        
        //初始化button	
	commitbtn=new JButton("注册");
	commitbtn.addActionListener(this);
	resetbtn=new JButton("重置");
	resetbtn.addActionListener(this);
	cancelbtn=new JButton("返回");
	cancelbtn.addActionListener(this);
	panel=new JPanel();
	panel.add(rbtn1);
	panel.add(rbtn2);
	Border border=BorderFactory.createTitledBorder("");//性别的边框
	panel.setBorder(border);
	box=Box.createHorizontalBox();//box容器
	box.add(commitbtn);//加入三个button   注册   重置   取消
	box.add(Box.createHorizontalStrut(30));
	box.add(resetbtn);
	box.add(Box.createHorizontalStrut(30));
	box.add(cancelbtn);
        
        //设置布局管理
	setLayout(new GridBagLayout());
        gbc=new GridBagConstraints();
        addComponent(titlelabel,0,0,4,1);
	add(Box.createVerticalStrut(20));
	gbc.anchor=GridBagConstraints.CENTER;
	gbc.fill=GridBagConstraints.HORIZONTAL;
	gbc.weightx=0;
	gbc.weighty=100;
        
        //加入组件
	addComponent(namelabel,0,1,1,1);
	addComponent(namefield,1,1,4,1);
	addComponent(pwdlabel1,0,2,1,1);
	addComponent(pwdfield1,1,2,4,1);
	addComponent(pwdlabel2,0,3,1,1);
	addComponent(pwdfield2,1,3,4,1);
	addComponent(sexlabel,0,4,1,1);
	addComponent(panel,1,4,1,1);
	addComponent(maillabel,0,5,4,1);
	addComponent(mailfield,1,5,4,1);
	addComponent(phonelabel,0,6,4,1);
	addComponent(phonefield,1,6,4,1);
	gbc.anchor=GridBagConstraints.EAST;
	gbc.fill=GridBagConstraints.NONE;
	addComponent(agelabel,2,4,1,1);
	gbc.fill=GridBagConstraints.HORIZONTAL;
	addComponent(agefield,3,4,1,1);
	gbc.anchor=GridBagConstraints.CENTER;
	gbc.fill=GridBagConstraints.NONE;
	addComponent(box,0,7,4,1);
        
        namefield.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(final FocusEvent arg0){
                if(namefield.getText().equals("请输入用户名")){
                    namefield.setText("");
                    namefield.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost (final FocusEvent arg0){
                if(namefield.getText().equals("")){
                    namefield.setText("请输入用户名");
                    namefield.setForeground(Color.gray);
                }
            }
        });
        
        mailfield.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(final FocusEvent arg0){
                if(mailfield.getText().equals("请输入Email地址")){
                    mailfield.setText("");
                    mailfield.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost (final FocusEvent arg0){
                if(mailfield.getText().equals("")){
                    mailfield.setText("请输入Email地址");
                    mailfield.setForeground(Color.gray);
                }
            }
        });
        
        phonefield.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(final FocusEvent arg0){
                if(phonefield.getText().equals("请输入电话")){
                    phonefield.setText("");
                    phonefield.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost (final FocusEvent arg0){
                if(phonefield.getText().equals("")){
                    phonefield.setText("请输入电话");
                    phonefield.setForeground(Color.gray);
                }
            }
        });
    }
    
    //定义加入组件的方法，参数分别为     组件名、行号、列号、宽、高
    public void addComponent(Component c,int x,int y,int w,int h){
	gbc.gridx=x;
	gbc.gridy=y;
	gbc.gridwidth=w;
	gbc.gridheight=h;
	add(c,gbc);
    }
    
    //监听器相应方法
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==commitbtn){//判断响应来源，此处为注册button
            RegisterInfo rinfo=new RegisterInfo();
            rinfo.name=namefield.getText().trim();//trim：去掉字符串首尾空格  防止不必要的空格导致错误
            rinfo.password=new String(pwdfield1.getPassword());
            rinfo.sex=rbtn1.isSelected()?"男":"女";
            rinfo.age=agefield.getText().trim();
            rinfo.phone=phonefield.getText().trim();
            rinfo.mail=mailfield.getText().trim();
            if(namefield.getText().equals("请输入用户名")||namefield.getText().length()==0){
                JOptionPane.showMessageDialog(null,"\t 用户名不能为空");
                rinfo=null;
            }
            else if(rinfo.password.length()==0){ 
		JOptionPane.showMessageDialog(null,"\t 密码不能为空 ");	
		rinfo=null;	
            }
            else if(!rinfo.password.equals(new String(pwdfield2.getPassword()))){
                JOptionPane.showMessageDialog(null,"密码两次输入不一致，请重新输入");
                rinfo=null;
            }
            else if(rinfo.age.length()==0){
                JOptionPane.showMessageDialog(null,"\t 年龄不能为空");
                rinfo=null;
            }
            else if(Integer.parseInt(rinfo.age)<=0||Integer.parseInt(rinfo.age)>100){//年龄要在这个范围，没有给出年龄输入字符的处理方法
                JOptionPane.showMessageDialog(null, "\t 年龄输入不合法");
		rinfo=null;
            }
            else if(rinfo.mail.length()==0){
                JOptionPane.showMessageDialog(null,"\t电子邮箱不能为空");
                rinfo=null;
            }
            else if(rinfo.phone.length()==0){
                JOptionPane.showMessageDialog(null,"\t 手机不能为空");
            }
        }							
	else if(e.getSource()==cancelbtn){//返回button
            //rf.setVisible(false);
            System.exit(0);
	}
	else if(e.getSource()==resetbtn){//重置button
            namefield.setText("");
            pwdfield1.setText("");
            pwdfield2.setText("");
            agefield.setText("");
            phonefield.setText("");
            mailfield.setText("");
            rbtn1.setSelected(true);
	}
    }
}