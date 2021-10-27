import java.awt.*; 
import java.awt.event.*; 

public class Question5 extends Frame implements ActionListener {
    TextField tf1, tf2, tf3 ; 
    Button btn1, btn2;

    public Question5( ) {
        Font large = new Font("Times New Roman", 0, 20 );
        this.setFont( large );

        this.setLayout( null );

        tf1 = new TextField(20);
        tf2 = new TextField(20);

        tf1.setBounds( 50, 50, 200, 40 );
        tf2.setBounds( 50, 100, 200, 40 );

        btn1 = new Button("ADD");
        btn2 = new Button("RESET");

        btn1.setBounds( 60, 150, 80, 50 );
        btn2.setBounds( 160, 150, 80, 50 );

        btn1.addActionListener( this );
        btn2.addActionListener( this );

        tf3 = new TextField(20);

        tf3.setBounds( 50, 250, 200, 40 );

        add( tf1 );
        add( tf2 );
        add( btn1 ); 
        add( btn2 ); 
        add( tf3 );
    }

    public void actionPerformed( ActionEvent ae ) {
        String s1 = ae.getActionCommand();

        if( s1.equals( "ADD" ) ) {
            // getting the values from tf1 and tf2 and putting it into tf3 
            try {
                int n1 = Integer.parseInt( tf1.getText() );
                int n2 = Integer.parseInt( tf2.getText() );
                
                tf3.setText( "" + ( n1 + n2) );
            }
            catch( NumberFormatException nfe ) { 
                tf3.setText("");
            }
        }
        else if( s1.equals( "RESET") ) {
            tf1.setText(""); 
            tf2.setText(""); 
            tf3.setText(""); 
        }
    }

    public static void main(String ar[] ){
        Question5 q5 = new Question5(); 
        q5.setSize( 300, 400 );
        q5.setVisible( true );
        q5.setTitle("Question-5");
    }
}