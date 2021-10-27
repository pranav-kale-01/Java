import java.awt.*;
class first extends Panel
{
	public first()
	{
		Label l1 = new Label("Enter Mob no."); 
		TextField username = new TextField( 26 );

		l1.setBounds( 150,25, 100, 10 );
		username.setBounds( 100, 50, 200 , 20 );
		
		Label L2 = new Label("Enter Password"); 
		TextField username1 = new TextField( 26 );

		L2.setBounds(150,80, 100, 10 );
		username1.setBounds( 100, 100, 200 , 20 );

		Button btn1 = new Button("Submit");
		btn1.setBackground( Color.RED ); 
		btn1.setForeground( Color.WHITE ); 

		btn1.setBounds(125, 180, 80, 20); 

		add(l1);
		add(L2);
		add(btn1);
		add(username);
	}
}
class Frame01 extends Frame
{
	public Frame01()
	{
		first f1 = new first();
       		 f1.setLayout( null );
       		 f1.setBounds( 0,0, 500,400);
		add(f1);
	}
	public static void main(String arr[])
	{
		Frame01 f11 = new Frame01();	
		f11.setSize(500, 400 );
	        	f11.setVisible( true );
	}
}