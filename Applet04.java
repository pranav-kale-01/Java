import java.applet.Applet; 
import java.awt.*; 
import java.awt.event.*;
import java.util.*;

/* 
* <applet code="Applet04.class" width="400" height="400">
* </applet>
*/

public class Applet04 extends Applet implements MouseListener { 
    Vector<Color> colors = new Vector<Color>(10);
    Vector<Integer> x_points = new Vector<Integer>(10);
    Vector<Integer> y_points = new Vector<Integer>(10);
    Applet currentFrame;
    boolean flag = true, _mouseClicked = false ; 

    public void init() {
        currentFrame = this;
        this.addMouseListener( this );   
    } 

    public void paint( Graphics g ) {
        if( this._mouseClicked ) {
            Iterator i1 = x_points.iterator();
            Iterator i2 = y_points.iterator();
            Iterator i3 = colors.iterator();
            
            while( i1.hasNext() && i2.hasNext() && i3.hasNext() ) {
                g.setColor( (Color) i3.next( ) );
                g.drawLine( (int) currentFrame.getSize().width/2, (int) currentFrame.getSize().height/2 , (int) i1.next(), (int) i2.next() );
            }   

            this._mouseClicked = false;
        }
    }

    public void mouseClicked( MouseEvent me ) {
        x_points.add( me.getX() );
        y_points.add( me.getY() );

        // creating new Object of Random 
        Random r = new Random(); 
        Color randomColor = new Color(0,0,0);
        flag = true;

        while( flag ) {
            int red = r.nextInt( 256 );
            int green = r.nextInt( 256 ); 
            int blue = r.nextInt( 256 );

            randomColor = new Color( red, green, blue); 

            flag = false;

            for( Color c : colors ) {
                if( c == randomColor ) {
                    flag = true;
                    break;
                }
            }
        }   
        
        colors.add( randomColor );

        this._mouseClicked = true;
        repaint();
    }

    public void mousePressed( MouseEvent me ) { }

    public void mouseReleased( MouseEvent me ) { }

    public void mouseEntered( MouseEvent me ) { }

    public void mouseExited( MouseEvent me ) { }
}