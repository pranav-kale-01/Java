package first;

import java.awt.*;
import java.awt.event.*;
import first.event1;

class panel1 extends Panel implements ActionListener
{
    String s1;
    Button b2;
    int count = 0;
    Label l1,l2,l3,l4;
    event1 e1;

    panel1(String s1)
    { 
        setLayout(new GridLayout(3,1));
        this.b2 = new Button("SUBMIT");
        this.b2.setBackground(Color.GREEN);
        this.b2.setBounds(125,475,80,40);
        
        e1 = new event1();

        this.l1 = new Label(s1+" "+count);
        this.l1.setBackground(Color.WHITE);
        this.l1.setForeground(Color.BLACK);
        this.l1.setBounds(200,10,100,100);
        this.l1.setFont(new Font("comic sans ms", Font.BOLD, 20));

        add(l1);
        add(e1);
        add(b2);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
	{
        e1.reset1();
		Object ob = ae.getSource();

		if (ob == this.b2)
        {
            count = count + 1 ; 
            l1.setText( " " + count );
            // e1.reset1();
        }
    }
}

public class vs1 extends Frame
{
    public vs1()
    {
        panel1 p1 = new panel1("Player-1");
        panel1 p2 = new panel1("Player-2");
        setLayout(new GridLayout(1,2));
        add(p1);
        add(p2);
    }

    public static void main(String arr[])
    {
        vs1 v1 = new vs1();
        v1.setVisible(true);
        v1.setSize(400,400);
        v1.setTitle("TRY");
    }
}