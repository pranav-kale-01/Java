import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EventDemo6 extends JFrame implements ActionListener 
{
    TextField t1,t2;
    Label display;
    JButton sign,reset;
    static EventDemo6.Users[] usr;
    
    public EventDemo6 ()
    {
        setLayout(new FlowLayout());
        Font font  = new Font("Arial",Font.PLAIN,15);

        t1 = new TextField(25);
        t2 = new TextField(25);
        t2.setEchoChar('*');

        display = new Label();

        sign = new JButton("Sign-In");
        reset = new JButton("Reset");

        t1.setFont(font);
        t2.setFont(font);
        display.setFont(font);
        sign.setFont(font);
        reset.setFont(font);

        sign.addActionListener(this);
        reset.addActionListener(this);

        add(t1);
        add(t2);
        add(sign);
        add(reset);
        add(display);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();

        if(obj == sign) {
            String user_id = t1.getText();
            String user_pass = t2.getText();
            int flag = 0;

            for(int i = 0; i < 5; i++) {
                System.out.println( usr[i].getid( ) ); 

                if(usr[i].getid() == user_id && usr[i].getpassword() == user_pass) {
                    display.setText("Login Successful");
                    flag = 1;
                    break;
                }
            }

            if(flag == 0) {
                display.setText("Invalid Credentials");
            }
        }
        else if(obj == reset) {
            display.setText(null);
            t1.setText(null);
            t2.setText(null);
            t1.requestFocus();
        }
    }

    public static void main(String[] args) {
        EventDemo6.usr = new EventDemo6.Users[5];
        Scanner scn = new Scanner(System.in);

        for(int i = 0 ; i < 5; i++) {
            System.out.println("Enter User-Id: ");
            String usr_id = scn.nextLine();

            System.out.println("Enter User-Password: ");
            String usr_psd = scn.nextLine();

            EventDemo6.usr[i].setid(usr_id);
            EventDemo6.usr[i].setpassword(usr_psd);
        }

        EventDemo6 frame = new EventDemo6();
        frame.setSize(335,300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class Users {
        String id,password;

        public void test() {
            System.out.println("test");
        }

        public String getid()
        {
            return this.id;
        }

        public String getpassword()
        {
            return this.password;
        }

        public void setid(String id)
        {
            this.id = id;
        }

        public void setpassword(String passw)
        {
            this.password = passw;
        }
    }
}