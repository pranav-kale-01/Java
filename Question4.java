import java.awt.*;
import java.awt.event.*; 
import java.applet.Applet; 

/* 
<applet code="Question4.class" width="300" height="300">
</applet>
*/

public class Question4 extends Applet implements ActionListener {
    Label lb1; 
    Scrollbar sc1, sc2, sc3;

    public void init() {
        this.lb1 = new Label("");
        this.lb1.setBackground( Color.RED );
        
        this.lb1.setBounds( 100, 20, 120, 100 );

        this.setLayout( null );

        Label l1 = new Label("0");
        Label l2 = new Label("0"); 
        Label l3 = new Label("0");

        l1.setBounds( 15, 185, 10, 10 );
        l2.setBounds( 15, 235, 10, 10 );
        l3.setBounds( 15, 285, 10, 10 );

        Label l4  = new Label("255"); 
        Label l5  = new Label("255"); 
        Label l6  = new Label("255"); 

        l4.setBounds( 285, 185, 25, 10 ); 
        l5.setBounds( 285, 235, 25, 10 );
        l6.setBounds( 285, 285, 25, 10 );

        Label l7 = new Label("red"); 
        Label l8 = new Label("green"); 
        Label l9 = new Label("blue"); 

        this.sc1 = new Scrollbar( Scrollbar.HORIZONTAL, 255, 1, 0, 256 ); 
        this.sc1.setBounds( 10, 150, 300 , 30);

        this.sc2 = new Scrollbar( Scrollbar.HORIZONTAL, 0, 1, 0, 256 ); 
        this.sc2.setBounds( 10, 200, 300 , 30);

        this.sc3 = new Scrollbar( Scrollbar.HORIZONTAL, 0, 1, 0, 256 ); 
        this.sc3.setBounds( 10, 250, 300 , 30);

        Button btn = new Button("CHECK"); 

        btn.setBounds( 150, 300, 55, 30 );
        btn.addActionListener( this );

        add( sc1 );   
        add( sc2 );   
        add( sc3 );       
        add(l1); 
        add(l2); 
        add(l3); 
        add(l4); 
        add(l5); 
        add(l6);
        add( btn );

        add( lb1 ); 

        this.setSize( 400, 400 );
    }


    public void actionPerformed( ActionEvent ae ){
        

        int red = sc1.getValue() ;
        int green = sc2.getValue(); 
        int blue = sc3.getValue();


        Color c = new Color( red, green, blue ); 

        this.lb1.setBackground( c );
    }
}