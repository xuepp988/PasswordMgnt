/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmgnt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

/**
 *
 * @author Yarrow
 */
class Account_GUI{
    public Account_GUI(){
        AccountFrame lf=new AccountFrame();
	lf.setVisible(true);//使窗口可见
    }
}

public class AccountFrame extends JFrame{
    private Toolkit tool;
    public AccountFrame(){
	setTitle("账户管理");
	tool=Toolkit.getDefaultToolkit();//获取默认工具包
	Dimension ds=tool.getScreenSize();//dimention  封装了构件高宽的类
	int w=ds.width;
	int h=ds.height;
	setBounds((w-300)/3,(h-300)/3-50,400,400);//设置位置与大小     左上角X坐标、左上角Y坐标、长、宽
	setResizable(true);//false表示不能改变窗口大小
	AccountPanel ap=new AccountPanel();
	add(ap);
    }
}

class AccountPanel extends JPanel implements ActionListener{
    private JLabel titlelabel;
    private JButton addbtn,delbtn;
    private GridBagConstraints gbc;//布局
    private Box box;//两个button
    JScrollPane sp;
    String[] columnNames = {"账号类型","账号","账号状态"};
    Object[][] data ={
        {"qq","10000","已/未登录"},{"taobao","taobao",""},{"gmail","gmail",""},{"Apple","Apple",""},{"Yahoo","Yahoo",""},{"weibo","weibo",""},{"Zhihu","Zhihu",""},
    };
    public JTable table;
    
    AccountPanel(){
        
        titlelabel=new JLabel("账户管理");
	titlelabel.setFont(new Font("微软雅黑",Font.BOLD,25));
        addbtn=new JButton("添加");
        addbtn.setFont(new Font("微软雅黑",Font.BOLD,12));
        delbtn=new JButton("删除");
        delbtn.setFont(new Font("微软雅黑",Font.BOLD,12));
        Border border=BorderFactory.createTitledBorder("");
        box=Box.createHorizontalBox();//box容器
	box.add(Box.createHorizontalStrut(90));
        box.add(addbtn);//加入两个button 
	box.add(Box.createHorizontalStrut(10));
	box.add(delbtn);

        JPanel p=new JPanel(new BorderLayout());
        table=new JTable(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {return false;};
        };
        table.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) { 
                if (e.getClickCount() == 2) { 
                    new PWD_GUI(); 
                } 
            } 
        });
        
        p.add(table.getTableHeader(),BorderLayout.PAGE_START);
        p.add(table,BorderLayout.CENTER);
        table.setRowHeight(40);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.setGridColor(Color.black);//设置网格线的颜色
        table.setFont(new Font("微软雅黑",Font.BOLD,12));
    
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints();
        addComponent(titlelabel,0,0,1,1);
    
        gbc.anchor=GridBagConstraints.CENTER;
	gbc.fill=GridBagConstraints.HORIZONTAL;
	gbc.weightx=0;
	gbc.weighty=100;
        
        addComponent(box,1,0,1,1);
        addComponent(p,0,1,2,10);
    }
    public void addComponent(Component c,int x,int y,int w,int h){
	gbc.gridx=x;
	gbc.gridy=y;
	gbc.gridwidth=w;
	gbc.gridheight=h;
	add(c,gbc);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}