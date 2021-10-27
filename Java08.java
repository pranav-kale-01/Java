import java.awt.*;
import java.applet.*; 

/*
<applet code=Java08.class height=200 width=200> 
</applet>
*/
public class Java08 extends Applet {
    public void init() {
        List l = new List( 2, true ); 
        l.add( "java" ); 
        l.add( "c++" );
        l.add( "kkk" ); 
        add( l ); 
    }
}