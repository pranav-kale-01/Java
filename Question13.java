import java.awt.*; 
import java.awt.event.*; 
import java.util.Scanner;

class Question13 extends Frame { 
    static Question13.User[] usr;
    TextField tf1, tf2;
    Label lb1;
    
    public Question13() {
        usr = new Question13.User[5];

        // creating new object of class Scanner 
        Scanner sc = new Scanner( System.in );

        for( int i=0; i<5; i++ ) {
            System.out.println("Enter the username and password : "); 
            usr[i] = this.new User();
            usr[i].setUsername( sc.nextLine() );
            usr[i].setPassword( sc.nextLine() );
        }

        // GUI 
        this.setLayout( null );

        Font large = new Font( "Times New Roman", Font.PLAIN, 24 );

        tf1 = new TextField();
        tf1.setFont( large );
        tf1.setBounds( 50, 100, 400, 40 );

        tf2 = new TextField();
        tf2.setFont( large );
        tf2.setBounds( 50, 150, 400, 40 );

        lb1 = new Label(); 
        lb1.setFont( large );
        lb1.setBounds( 120, 200, 300, 40 );

        Button sign_in = new Button("Sign In"); 
        sign_in.setFont( large );
        sign_in.setBounds( 60, 250, 150, 40 );
        sign_in.addActionListener( new SignInEvent() );

        Button reset = new Button("Reset");
        reset.setFont( large );
        reset.setBounds( 250, 250 , 150, 40 );
        reset.addActionListener( new ResetEvent() );

        add( tf1 );
        add( tf2 );
        add( lb1 ); 
        add( sign_in ); 
        add( reset );
    }

    class SignInEvent implements ActionListener {
        public void actionPerformed( ActionEvent ae ) {
            for( int i=0 ; i<5; i++ ) {
                if( usr[i].getUsername() != null && usr[i].getUsername().equals( tf1.getText() ) && usr[i].getPassword().equals( tf2.getText() ) ) {
                    lb1.setText("Sign-In Successfull");
                    return;
                }
            }
            lb1.setText("Sign-In Failed");
        } 
    }

    class ResetEvent implements ActionListener {
        public void actionPerformed( ActionEvent ae ) {
            tf1.setText( "" );
            tf2.setText( "" );
            lb1.setText( "" );
        }  
    }

    public static void main( String ar[] ) {       
        Question13 q = new Question13(); 

        // initializing the Frame 
        q.setSize( 500, 400 ); 
        q.setVisible( true );
    }

    class User {
        private String username, password; 

        public void test() {
            System.out.println("test");
        }

        public String getUsername() {
            return this.username;
        }

        public String getPassword() {
            return this.password; 
        }

        public void setUsername( String username ) {
            this.username = username;
        }

        public void setPassword( String password ) {
            this.password = password;
        }
    }
}