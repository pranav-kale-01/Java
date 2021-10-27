import java.applet.Applet; 
import java.awt.*; 

/*
<applet code="Applet02.class" width="300" height="300"> 
</applet> 
*/


public class Applet02 extends Applet {
    public void init() {
        // creating a new button
        Button btn1 = new Button("Click Here"); 

        // adding the button to 100,100 
        btn1.setLocation( 100, 100 );
        btn1.setSize( 100, 20 );
        add( btn1 ); 
    }
}