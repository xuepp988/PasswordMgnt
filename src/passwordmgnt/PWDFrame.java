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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Yarrow
 */
class PWD_GUI{
    public PWD_GUI(){
        PWDFrame lf=new PWDFrame();
	lf.setVisible(true);//使窗口可见
    }
}

public class PWDFrame extends JFrame{
    private Toolkit tool;
    public PWDFrame(){
	setTitle("密码管理");
	tool=Toolkit.getDefaultToolkit();//获取默认工具包
	Dimension ds=tool.getScreenSize();//dimention  封装了构件高宽的类
	int w=ds.width;
	int h=ds.height;
	setBounds((w-300)/3,(h-300)/3-50,300,300);//设置位置与大小     左上角X坐标、左上角Y坐标、长、宽
	setResizable(true);//false表示不能改变窗口大小
	PWDPanel pwdp=new PWDPanel();
	add(pwdp);
    }
}

class PWDPanel extends JPanel implements ActionListener{
    private JLabel titlelabel,accountlabel,authcodelabel,namelabel,pwdlabel;
    private JTextField accountfield,authcodefield,namefield,pwdfield;
    private JButton commitbtn,cancelbtn,resetbtn;
    private GridBagConstraints gbc;//布局
    private Box box;//三个button
        
    PWDPanel(){
        Font font = new Font("微软雅黑", Font.BOLD,12 );
        UIManager.put("Label.font",font);
        UIManager.put("Button.font",font);
        UIManager.put("TextField.font",font);
        titlelabel=new JLabel("密码管理");
	titlelabel.setFont(new Font("微软雅黑",Font.BOLD,25));
	accountlabel=new JLabel("账     户：");
	authcodelabel=new JLabel("验 证 码：");
        accountfield=new JTextField(8);
        accountfield.setText("显示值");
        accountfield.setEditable(false); 
        accountfield.setForeground(Color.gray);
        namelabel=new JLabel("用 户 名：");
        namefield=new JTextField(8);
        namefield.setText("显示值");
        namefield.setEditable(false); 
        namefield.setForeground(Color.gray);
        pwdlabel=new JLabel("密     码：");
        pwdfield=new JTextField(8);
        pwdfield.setText("显示值");
        pwdfield.setEditable(false); 
        pwdfield.setForeground(Color.gray);
        authcodefield=new JTextField(8);
        authcodefield.setText("请在一分钟内输入");
        authcodefield.setForeground(Color.gray);
        commitbtn=new JButton("提交");
	commitbtn.addActionListener(this);
        resetbtn=new JButton("重置");
	resetbtn.addActionListener(this);
	cancelbtn=new JButton("取消");
	cancelbtn.addActionListener(this);
        
        box=Box.createHorizontalBox();//box容器
	box.add(commitbtn);//加入三个button
	box.add(Box.createHorizontalStrut(10));
	box.add(cancelbtn);
        box.add(Box.createHorizontalStrut(10));
	box.add(resetbtn);
        
        JLabel typelabel=new JLabel("获取验证码：");
        String[] typeStrings = { "电子邮件", "手机",};
        JComboBox typeList = new JComboBox(typeStrings);
        typeList.setSelectedIndex(1);
        typeList.setFont(font);
        typeList.addActionListener(this);

        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints();
        addComponent(titlelabel,0,0,4,1);
        add(Box.createVerticalStrut(20));
        
        gbc.anchor=GridBagConstraints.CENTER;
	gbc.fill=GridBagConstraints.HORIZONTAL;
	gbc.weightx=0;
	gbc.weighty=100;
        
        addComponent(accountlabel,0,1,1,1);
	addComponent(accountfield,1,1,6,1);
        addComponent(typelabel,0,2,1,1);
        addComponent(typeList,1,2,6,1);
	addComponent(authcodelabel,0,3,1,1);
	addComponent(authcodefield,1,3,6,1);
        addComponent(box,0,4,4,1);
        addComponent(namelabel,0,5,1,1);
	addComponent(namefield,1,5,6,1);
        addComponent(pwdlabel,0,6,1,1);
	addComponent(pwdfield,1,6,6,1);
        
        authcodefield.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(final FocusEvent arg0){
                if(authcodefield.getText().equals("请在一分钟内输入")){
                    authcodefield.setText("");
                    authcodefield.setForeground(Color.black);
                }
            }
            @Override
            public void focusLost (final FocusEvent arg0){
                if(authcodefield.getText().equals("")){
                    authcodefield.setText("请在一分钟内输入");
                    authcodefield.setForeground(Color.gray);
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
        if(e.getSource()==commitbtn){
            if(authcodefield.getText().equals("请在一分钟内输入")||authcodefield.getText().length()==0){
                JOptionPane.showMessageDialog(null,"\t 验证码不能为空 ");
            }
        }
        else if(e.getSource()==cancelbtn){//返回button
            System.exit(0);
	}
        else if(e.getSource()==resetbtn){//重置button
            authcodefield.setText("");
	}
    }
}