import java.awt.*;
import java.awt.event.*;


class event2 extends Frame implements ActionListener
{
	Button b1;
	private Frame invoking_window; 
	public event2(Frame obj)
	{
		this.invoking_window = obj; 
		setLayout(new GridLayout(6,4,10,10));
		b1 = new Button("");
		add(b1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		this.setVisible(false);
		this.invoking_window.setVisible( true );
	}
}

class event1 extends Frame implements ActionListener
{
	Button b2;
	public event1()
	{
		setLayout(new GridLayout(6,4,10,10));
		b2 = new Button("Next");
		add(b2);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
	
		event2 e2 = new event2(this);
		e2.setSize(400,400);
		e2.setTitle("Home Page");

		e2.setVisible(true);
		this.setVisible(false);
	}

	public static void main(String arr[])
	{
		event1 e1 =  new event1();
		e1.setVisible(true);	
		e1.setSize(400,400);
		e1.setTitle("Home Page");

	}
}