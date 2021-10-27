import java.awt.*; 
import java.applet.Applet; 

/*
<applet code="Applet03.class" height="400" width="400"> 
</applet>
*/ 

// program to create A Choice menu 

public class Applet03 extends Applet {
    public void init() {
        this.setLayout( null );

        Choice ch1 = new Choice(); 
        ch1.setSize( 100, 20 );
        ch1.setLocation( 100, 100 );

        for( int i=0; i<10; i++ ){
            ch1.add( "" + i );
        }

        add( ch1 );
    }
}