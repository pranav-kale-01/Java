import java.awt.*;
import java.awt.event.*;

class calci implements ActionListener
{
  //  int c,n;
    String s1,s2,s3,s4,s5;
    Frame f;
    Button b1,b2,b3;
   // Panel p;
    TextField tf1,tf2,tf3;
   // GridLayout g;

    public calci()
    {
        f = new Frame("My calculator");
       // p = new Panel();
        f.setLayout(null);

        b1 = new Button("ADD");
        b1.setBounds(200, 210, 70, 30);
        b1.addActionListener(this);

        b2 = new Button("RESET");
        b2.setBounds(300, 210, 70, 30);
        b2.addActionListener(this);

        tf1 = new TextField(20);
        tf1.setBounds(150, 110, 110, 20);

        tf2 = new TextField(20);
        tf2.setBounds(150,140,110,20);

        tf3 = new TextField(20);
        tf3.setBounds(150,250,110,20);

        f.add(tf1);
        f.add(tf2);
        f.add(b1);
        f.add(b2);
        f.add(tf3);

        f.setSize(300,300);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Object ob = e.getSource();
        if(ob == b1)
        {
			s1 = tf1.getText();
			s2 = tf2.getText();
			int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            int c = a + b;

            tf3.setText(" " +c);
		}

		else if(ob == b2) {
			//RESET LOGIC
			tf1.setText(null);
			tf2.setText(null);
			tf3.setText(null);
		}
    }

    public static void main(String ar[])
    {
        calci v = new calci();
    }
}