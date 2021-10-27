import java.awt.*; 
import java.applet.Applet; 

class MyFrame extends Frame {
    public MyFrame() {
        Button btn1 = new Button(); 

        add( btn1 ); 
    } 

    public static void main(String ar[] ) {
        MyFrame mf1 = new MyFrame(); 

        mf1.setVisible( true ); 
        mf1.setSize( 400, 400 );
    }
}