import java.awt.*; 

class RegisterUserPanel extends Panel {
    public RegisterUserPanel() {
        Font title = new Font("Segoe UI", Font.PLAIN, 22 );
        Font text = new Font("Segoe UI", Font.PLAIN, 16 );


        Label l1 = new Label("Welcome, Please Sign-in to Continue...");
        l1.setFont( title ); 
        l1.setBounds( 20, 100, 400, 30 );   

        // Username TextField 
        Label l2 = new Label("Username"); 
        TextField username = new TextField( 26 );

        l2.setFont( text );
        l2.setBounds( 30 , 185 , 120, 20 );
        username.setFont( text ); 
        username.setBounds( 150, 180 , 200 , 30 );

        // passowrd TextField 
        Label l3 = new Label("Password"); 
        TextField password = new TextField( 26 );
        
        l3.setFont( text );
        l3.setBounds( 30, 245, 120, 20 );
        password.setFont( text );
        password.setBounds( 150, 245, 200 , 30 );
        
        // setting the EchoChar for password field as * 
        password.setEchoChar('*');
        
        // // adding submit Button 
        Button btn1 = new Button("Submit"); 
        
        btn1.setFont( text );
        btn1.setBounds( 150, 320, 100, 40);
        btn1.setBackground( new Color( 247, 245, 245 ) );

        // adding all the Components to the Panel
        add( l1 );

        add( l2 );
        add( username ); 

        add( l3 ); 
        add( password ); 

        add( btn1 );

        // setting Panel Visibility to true
        setVisible(true);
    }
}


public class Frame01 extends Frame {
    public Frame01( ) {
        RegisterUserPanel panel1 = new RegisterUserPanel();
        setTitle("Register Page");

        panel1.setLayout(null); 
        panel1.setBounds( 0, 300 , 450, 800 ); 
        panel1.setVisible( true );
        panel1.setBackground( Color.white);
        add( panel1 );
    }

    public static void main( String ar[] ) {
        Frame01 f1 = new Frame01();
        f1.setBounds( 0, 0, 450, 800 );
        f1.setVisible(true);
    }
}