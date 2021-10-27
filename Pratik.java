import java.awt.*;
import java.awt.event.*;
class event1 extends Frame implements	 ActionListener 
{
	TextField t1,t2,t3;
	static int choice=0;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	Label l1,l2,l3,l4,l5,l6;
	public event1()
	{
		setLayout(new GridLayout(8,3,10,10));
		t1 = new TextField();
		t1.setFont(new Font("Arial Black", Font.BOLD, 22));
		t2 = new TextField();
		t2.setFont(new Font("Arial Black", Font.BOLD, 22));
		t3 = new TextField();
		t2.setFont(new Font("Arial Black", Font.BOLD, 22));
		
		l1 = new Label("         A ");
		l1.setFont(new Font("Arial Black", Font.BOLD, 20));
		l2 = new Label("         B ");
		l2.setFont(new Font("Arial Black", Font.BOLD, 20));      
		l3 = new Label("        Ans");
		l3.setFont(new Font("Arial Black", Font.BOLD, 20));
		l4 = new Label("");
		l5 = new Label("");
		l6= new Label("");
	
	
		b1 = new Button("7");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("comic sans ms", Font.BOLD, 20));

		b2 = new Button("8");
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("comic sans ms", Font.BOLD, 20));

		b3 = new Button("9");
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("comic sans ms", Font.BOLD, 20));

		b4 = new Button("4");
		b4.setBackground(Color.WHITE);
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("comic sans ms", Font.BOLD, 20));

		b5 = new Button("5");
		b5.setBackground(Color.WHITE);
		b5.setForeground(Color.BLACK);	
		b5.setFont(new Font("comic sans ms", Font.BOLD, 20));
	
		b6 = new Button("6");
		b6.setBackground(Color.WHITE);
		b6.setForeground(Color.BLACK);
		b6.setFont(new Font("comic sans ms", Font.BOLD, 20));

		b7 = new Button("1");
		b7.setBackground(Color.WHITE);
		b7.setForeground(Color.BLACK);
		b7.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		b8 = new Button("2");
		b8.setBackground(Color.WHITE);
		b8.setForeground(Color.BLACK);	
		b8.setFont(new Font("comic sans ms", Font.BOLD, 20));
	
		b9 = new Button("3");
		b9.setBackground(Color.WHITE);
		b9.setForeground(Color.BLACK);
		b9.setFont(new Font("comic sans ms", Font.BOLD, 20));

		b10 = new Button("0");
		b10.setBackground(Color.WHITE);
		b10.setForeground(Color.BLACK);
		b10.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		b11 = new Button("+");
		b11.setBackground(Color.RED);
		b11.setForeground(Color.BLACK);
		b11.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		b12 = new Button("-");
		b12.setBackground(Color.BLUE);
		b12.setForeground(Color.BLACK);
		b12.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		
		b13 = new Button("X");
		b13.setBackground(Color.YELLOW);
		b13.setForeground(Color.BLACK);
		b13.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		b14 = new Button("/");
		b14.setBackground(Color.GREEN);
		b14.setForeground(Color.BLACK);
		b14.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		b15 = new Button("C");
		b15.setBackground(Color.BLACK);
		b15.setForeground(Color.WHITE);
		b15.setFont(new Font("comic sans ms", Font.BOLD, 20));

		add(l1);
		add(t1);
		add(l4);
		add(l2);
		add(t2);
		add(l5);
		add(l3);
		add(t3);
		add(l6);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b11);
		add(b10);
		add(b12);
		add(b13);
		add(b14);
		add(b15);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public  void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();
		if (ob == b1)
		{
			if (choice==0)
			{
				t1.setText(t1.getText() + "7");	
			}
			else if(choice==1)
                			{
                    			t2.setText(t2.getText() + "7");	
                			}
		}
		else if (ob == b2)
		{
			if (choice==0)
			{
				t1.setText(t1.getText() + "8");	
			}
			else if(choice==1)
                			{
                    			t2.setText(t2.getText()+"8");
                			}
		}
	}
	public static void main(String arr[])
	{
		event1 e2 = new event1();
		Color c = new Color(192,192,192);
		e2.setBackground(c);
		e2.setVisible(true);	
		e2.setSize(400,600);
		e2.setTitle("CLCULATOR");
	}
}