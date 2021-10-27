import java.awt.*; 
import java.awt.event.*; 


class Question9 extends Frame {
    TextField tf1, tf2, tf3;

    public Question9() {
        tf1 = new TextField( ); 
        tf1.setBounds( 100, 50, 300, 30 );

        tf2 = new TextField( );
        tf2.setBounds( 100, 100, 300, 30 );

        Button btn1 = new Button( "ADD" );
        btn1.addMouseListener( new AddButtonEvent() );
        btn1.setBounds( 200, 150, 50, 30 );

        tf3 = new TextField( ) ;
        tf3.setBounds( 100, 200, 300, 30 );  


        this.setLayout( null );

        add( tf1 );
        add( tf2 );
        add( btn1 );
        add( tf3 );
    }


    class AddButtonEvent implements MouseListener {
        public void mouseClicked( MouseEvent me ) {

        }

        public void mousePressed( MouseEvent me ) {

        }

        public void mouseReleased( MouseEvent me ) {

        }

        public void mouseEntered( MouseEvent me ) {
            try 
            {
                int n1 = Integer.parseInt( tf1.getText() );
                int n2 = Integer.parseInt( tf2.getText() );

                tf3.setText( "" + ( n1 + n2 ) ) ;
            }
            catch( NumberFormatException nfe ) {
                tf1.setText("") ;
                tf2.setText("") ;
                tf3.setText("") ;
            }
        }

        public void mouseExited( MouseEvent me ) {
            tf1.setText("") ;
            tf2.setText("") ;
            tf3.setText("") ;
        }
    }
    

    public static void main(String ar[] ){
        Question9 q9 = new Question9(); 

        q9.setSize( 450, 800 );
        q9.setVisible( true );
    }
}