import java.awt.*;  
import java.awt.event.*;  

class paint extends Frame
{ 
    Graphics g;
    Color mainColor Color.RED;
        
    paint()
    {  
        b1 = new Button();
        b1.setBounds(250,100,80,30);
        b1.setBackground(Color.RED);
        add(b1);

        this.addMouseMotionListener( new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) 
            {  
                    g = getGraphics(); 
                    g.setColor( mainColor );  
                    g.fillOval(e.getX(),e.getY(),10,10);  
            }

        });  

        b1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                if( mainColor.equals( Color.RED ) ) {
                    mainColor = Color.BLUE;
                }
                else {
                    mainColor = Color.RED;
                }

                b1.setBackground(Color.BLUE);
                System.out.println("Red");	
            }
        });  
    }
    
    public static void main(String[] args) 	
    {  
        paint p1 = new paint();
        p1.setSize(500,500);  
        p1.setLayout(null);  
        p1.setVisible(true);  
    }  
}