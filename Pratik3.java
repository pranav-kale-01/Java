import java.awt.*;
import java.awt.event.*;

class event1 extends Frame 
{
	Button b1;
	TextField t1,t2,t3;
	public event1()
	{
		setLayout(new GridLayout(6,3,10,10));
		b1 = new Button("ADD");
		
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		
		add(t1);
		add(t2);
		add(b1);
		add(t3);
		
		inner1 i1 = new inner1();
		b1.addMouseListener(i1);
	}
	class inner1 implements MouseListener
	{
		public void mouseClicked(MouseEvent ae)
		{
	
		}
		public void mouseEntered(MouseEvent ae)
		{
			String s1 = t1.getText();
			String s2 = t2.getText();
			int a = Integer.parseInt(s1);
			int b = Integer.parseInt(s2);
			int c  = a + b;
			t3.setText(""+c);
			b1.setBackground(Color.WHITE);
			b1.setForeground(Color.RED);
		}
		public void mouseExited(MouseEvent ae)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			b1.setBackground(Color.WHITE);
			b1.setForeground(Color.GREEN);
		}
		
		public void mousePressed(MouseEvent ae)
		{
	
		}
		public void mouseReleased(MouseEvent ae)
		{
	
		}		
	}
	public static void main(String arr[])
	{
		event1 e1 = new event1();
		e1.setVisible(true);
		e1.setSize(400,400);
		e1.setTitle("Mouse event");
	}	
}