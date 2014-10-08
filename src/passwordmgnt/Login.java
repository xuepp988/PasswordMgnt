/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmgnt;
/**
 *
 * @author Yarrow
 */
class Login_GUI{
    public Login_GUI(){
        LoginFrame lf=new LoginFrame();
	lf.setVisible(true);					//使窗口可见
    }
}

public class Login {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Login_GUI lg=new Login_GUI();
    }
}
