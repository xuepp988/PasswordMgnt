/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmgnt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
/**
 *
 * @author Yarrow
 */
public class LoginFrame extends JFrame{
    private Toolkit tool;
    public LoginFrame(){
	setTitle("用户登录");
	tool=Toolkit.getDefaultToolkit();//获取默认工具包
	Dimension ds=tool.getScreenSize();//dimention  封装了构件高宽的类
	int w=ds.width;
	int h=ds.height;
	setBounds((w-300)/3,(h-300)/3-50,300,200);//设置位置与大小     左上角X坐标、左上角Y坐标、长、宽
	setResizable(true);//false表示不能改变窗口大小
	LoginPanel lp=new LoginPanel();
	add(lp);
    }
}

class LoginPanel extends JPanel implements ActionListener{
    private JLabel titlelabel,namelabel,pwdlabel;
    private JTextField namefield;
    private JPasswordField pwdfield;
    private JButton commitbtn,regbtn;
    private GridBagConstraints gbc;//布局
    private Box box;//两个button
        
    LoginPanel(){
        Font font = new Font("微软雅黑", Font.BOLD,12 );
        UIManager.put("Label.font",font);
        UIManager.put("Button.font",font);
        UIManager.put("TextField.font",font);
        titlelabel=new JLabel("密码管理系统");
	titlelabel.setFont(new Font("微软雅黑",Font.BOLD,25));
	namelabel=new JLabel("用 户 名：");
	pwdlabel=new JLabel("密     码：");
        namefield=new JTextField(8);
        namefield.setText("请输入用户名");
        namefield.setForeground(Color.gray);
        pwdfield=new JPasswordField(8);
	pwdfield.setEchoChar('*');
        commitbtn=new JButton("登录");
	commitbtn.addActionListener(this);
	regbtn=new JButton("注册");
	regbtn.addActionListener(this);
        
        box=Box.createHorizontalBox();//box容器
	box.add(commitbtn);//加入两个button   登录 注册
	box.add(Box.createHorizontalStrut(30));
	box.add(regbtn);
        
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints();
        addComponent(titlelabel,0,0,4,1);
        add(Box.createVerticalStrut(20));
        
        gbc.anchor=GridBagConstraints.CENTER;
	gbc.fill=GridBagConstraints.HORIZONTAL;
	gbc.weightx=0;
	gbc.weighty=100;
        
        addComponent(namelabel,0,1,1,1);
	addComponent(namefield,1,1,4,1);
	addComponent(pwdlabel,0,2,1,1);
	addComponent(pwdfield,1,2,4,1);
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
    }
    
    public void addComponent(Component c,int x,int y,int w,int h){
	gbc.gridx=x;
	gbc.gridy=y;
	gbc.gridwidth=w;
	gbc.gridheight=h;
	add(c,gbc);
    }
            
    @Override
    public void actionPerformed(ActionEvent e){       
        if(e.getSource()==commitbtn){//判断响应来源，此处为登录button
            if(namefield.getText().equals("请输入用户名")){
                JOptionPane.showMessageDialog(null,"\t 用户名不能为空");
            }
            else if(pwdfield.getPassword().length==0){ 
		JOptionPane.showMessageDialog(null,"\t 密码不能为空 ");
            }
            else{
                RegisterInfo linfo=new RegisterInfo();
                //TODO：查询数据库,核对后登录
                new Account_GUI();
            }
        }
        else if(e.getSource()==regbtn){     //注册button
            new Register_GUI();
        //    System.exit(0);
	}
    }
}