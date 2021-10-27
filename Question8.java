import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class Question8 extends Frame implements ItemListener, AdjustmentListener{
    JLabel l;
    Choice ch1, ch2;
    Scrollbar sb1;

    public Question8() {
        this.setLayout( null );

        Font large = new Font( "Time new Roman", Font.PLAIN, 24 );

        l = new JLabel( "This is Sample Text"); 
        l.setFont( new Font( "Comic Sans MS", Font.PLAIN, 24 ) );
        
        
        l.setBounds( 0,0, 450, 300 );
        add( l ); 

        Panel p1 = new Panel( );
        
        p1.setLayout( null );

        Label l1 = new Label("Type");
        Label l2 = new Label("Style");
        Label l3 = new Label("Size");

        l1.setBounds( 30, 120, 100, 30 );
        l2.setBounds( 30, 180, 100, 30 );
        l3.setBounds( 30, 240, 100, 30 );

        l1.setFont( large );
        l2.setFont( large );
        l3.setFont( large );

        p1.add( l1 );
        p1.add( l2 );
        p1.add( l3 );

        ch1 = new Choice();
        ch1.addItemListener( this );

        ch1.add("Calibri");
        ch1.add("Cambria Math");
        ch1.add("Comic Sans MS");
        ch1.add("Courier New");
        ch1.add("Gabriola");
        ch1.add("Times New Roman");

        ch1.setFont( large );
        ch1.setBounds( 130, 120, 250, 30 );
        p1.add( ch1 );

        ch2 = new Choice(); 
        ch2.addItemListener( this );

        ch2.add( "PLAIN" ); 
        ch2.add( "BOLD" );
        ch2.add( "ITALIC" ); 
        ch2.add( "BOLD + ITALIC" );

        ch2.setFont( large );
        ch2.setBounds( 130, 180, 250, 30 ); 
        p1.add( ch2 );        

        sb1 = new Scrollbar ( Scrollbar.HORIZONTAL, 24, 0, 1, 64 );
        sb1.addAdjustmentListener( this );
        sb1.setBounds( 130, 240, 250, 20 );
        sb1.setFont( large );

        p1.add( sb1 );

        p1.setBounds( 0, 300, 450, 800 );

        add( p1 );
    }

    public void itemStateChanged( ItemEvent ie ) {
        l.setFont( new Font( ch1.getSelectedItem() , ch2.getSelectedIndex(), sb1.getValue() ) );
    }

    public void adjustmentValueChanged( AdjustmentEvent ae ) {
        l.setFont( new Font( ch1.getSelectedItem() , ch2.getSelectedIndex(), sb1.getValue() ) );
    }

    public static void main( String ar[] ) {
        Question8 q8 = new Question8(); 

        q8.setSize( 450, 800 );
        q8.setVisible( true );
    }
}