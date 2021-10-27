import java.awt.*; 
import java.awt.event.*; 


class AdjustmentPanel extends Panel implements ActionListener {
    TextField tf1;

    public AdjustmentPanel(){
        Font large = new Font( "Segoe UI", Font.BOLD, 24 ); 
        Font largePlain = new Font( "Segoe UI", Font.PLAIN, 24 );

        Button btn1 = new Button("-");
        tf1 = new TextField( "0", 3 );
        Button btn2 = new Button("+"); 

        btn1.setFont( large );
        btn2.setFont( large );
        tf1.setFont( largePlain );

        btn1.addActionListener( this ); 
        btn2.addActionListener( this ); 

        add( btn1 ); 
        add( tf1 );
        add( btn2 );    
    }

    public int getValue( ) {
        return Integer.parseInt( tf1.getText() );
    }

    public void actionPerformed( ActionEvent ae ) {
        String s = ae.getActionCommand(); 

        if( s.equals("-") ) {
            int value = Integer.parseInt( tf1.getText() ); 

            if( value != 0 ) {
                tf1.setText( "" + --value );
            }
        } 
        else if( s.equals("+") ) {
            int value = Integer.parseInt( tf1.getText() ); 

            if( value < 256 ) {
                tf1.setText( "" + ++value );
            }
        }
    }
}  

public class Question6 extends Frame implements ActionListener { 
    Label l1; 
    AdjustmentPanel ap1, ap2, ap3;

    public Question6() {
        Font largePlain = new Font( "Segoe UI", Font.PLAIN, 24 );
        Panel p1 = new Panel( );
        p1.setLayout( null );

        this.l1 = new Label( ); 
        this.l1.setBackground( new Color(0,0,0) );
        this.l1.setSize( 120,100 );
        this.l1.setLocation( 130, 0 );

        p1.add( l1 );

        this.ap1 = new AdjustmentPanel();
        this.ap2 = new AdjustmentPanel();
        this.ap3 = new AdjustmentPanel();

        Button btn = new Button( "CHECK" );
        btn.setFont( largePlain );
        btn.addActionListener( this );
        
        this.setLayout( new GridLayout( 5, 1) );
        this.add( p1 );
        this.add( ap1 );
        this.add( ap2 ); 
        this.add( ap3 ); 
        this.add( btn );
    }

    public void actionPerformed( ActionEvent ae ) {
        int red = ap1.getValue();
        int green = ap2.getValue();
        int blue = ap3.getValue();

        l1.setBackground( new Color( red, green, blue ) );
    }

    public static void main( String ar[] ) {
        Question6 q6 = new Question6(); 
        q6.setSize( 400, 300 ); 
        q6.setVisible( true ); 
    }
}