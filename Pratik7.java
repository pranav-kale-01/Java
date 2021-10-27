import java.awt.*;
import java.awt.event.*;

class Pratik7 extends Frame
{
    Pratik7()
    {
        for(int i = 1;i<=100;i++)
        {
            setLayout(new FlowLayout());
            Button b1 = new Button();

            b1.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent ae ) {
                    System.out.println("Clicked");
                }
            });
            add(b1);
        }
    }
    public static void main(String arr[])
    {
        Pratik7 p1 = new Pratik7();
        p1.setVisible(true);    
        p1.setSize(400,400); 
    }
}