import java.awt.*; 
import java.awt.event.*; 

class Stack {
    private int[] stack; 
    int base; 
    int size;
    boolean overflow= false, underflow = true; 

    public Stack( int size ) {
        stack = new int[size]; 
        base = -1;
        this.size = size;
    } 

    public void push( int element ) {
        if( base < size -1 ) {
            this.overflow = false;
            stack[++base] = element; 
        }
        else {
            this.overflow = true; 
        }
    }

    public int pop() {
        if( base >= 0 ) {
            base--;
            this.underflow = false;
            return stack[base+1];
        }
        else{
            this.underflow = true;
            return -1; 
        }
    }

    public String toString( ) {
        String str = "";

        for( int i=size-1; i>=0; i-- ) {
            if( i <= base ) 
            {
                str += stack[i] + "\n"; 
            }
            else { 
                str += "\n";
            }
        } 
        return str;
    }
}

public class Question10 extends Frame 
{ 
    TextField tf1; 
    Label lb1; 
    
    public Question10() 
    {
        this.setLayout( new GridLayout( 1, 2 ) );
        Font large = new Font("Times New Roman", Font.BOLD, 28 );

        Panel p1 = new Panel();

        TextArea t1 = new TextArea( 10, 30 );
        t1.setFont( large );
        t1.setText( "\n\n\n\n\n\n\n\n\n");

        p1.add( t1 );

        Panel p2 = new Panel();
        p2.setLayout( null );

        tf1 = new TextField( 30 ) ;
        tf1.setFont( large );
        p2.add( tf1 );

        lb1 = new Label( "" ) ;
        lb1.setFont( large );
        lb1.setAlignment( 1 );
        p2.add( lb1 );


        // Creating an object of Stack 
        Stack s = new Stack( 10 );

        Button btn1 = new Button( "Push" ) ; 
        btn1.setFont( large );
        btn1.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                // getting the value from the TextField 
                try {
                    int number = Integer.parseInt( tf1.getText() );
                    s.push( number );

                    if( s.overflow == true ){
                        lb1.setText("Stack Overflow!");
                    }
                    else {
                        s.underflow = false;
                        lb1.setText( "" );
                    }   

                    t1.setText( s.toString() );
                }
                catch( Exception e ) {
                    lb1.setText( "Invalid Input, please re-enter");
                }
                tf1.setText( "" );
            } 
        });
        p2.add( btn1 );

        Button btn2 = new Button( "Pop" ) ; 
        btn2.setFont( large );
        btn2.addActionListener( new ActionListener( ) {
            public void actionPerformed( ActionEvent ae ) {
                int n = s.pop();

                if( n == -1 ) {
                    s.underflow = true;
                    tf1.setText( "" );
                    lb1.setText( "Stack Underflow!");
                    return;
                }
                else {
                    lb1.setText( "" );
                    tf1.setText( "" + n );
                
                    t1.setText( s.toString());
                }
            }
        });
        p2.add( btn2 );

        tf1.setBounds( 20, 20, 500, 40 );
        lb1.setBounds( 20, 70, 500, 40 );
        btn1.setBounds( 20, 120, 500, 40 );
        btn2.setBounds( 20, 170, 500, 40 );

        add( p1 );
        add( p2 );
    }

    public static void main( String ar[] ) {
        Question10 q10 = new Question10();
        q10.setSize( 800, 450);
        q10.setVisible( true );
    }
}