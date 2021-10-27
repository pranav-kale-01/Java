package first;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class event1 extends Panel implements ActionListener      
{
	Button b1 , b2 , b3, b4, b5 , b6 ,b7,b8 ,b9;
	String t1 ,t2,t3,t4,t5,z1,z2,z3,z4,z5,z6,z7,z8;
  	int[] arr={1,2,3,4,5,6,7,8};
	int[] arr2 = new int[8];
	int count =0;
	int x1,x2,x3,x4,x5,x6,x7,x8;
	Random r;

	public void method1()
	{
		System.out.println("test");
		r = new Random();    

		for(int i =0 ;i<arr.length;i++)
		{
			int randomNumber;
			do
			{
				randomNumber=r.nextInt(arr.length);				
			}while(arr[randomNumber] == -1);
	
			arr2[count] = arr[randomNumber];
			arr[randomNumber] = -1;
			
			count= count+1;
		}
		
		for( int i=0; i<arr2.length; i++) 
		{
			System.out.print( arr2[i] + "\n" );
		}
    }	
	
	public void reset1() {
		System.out.println("test");

		r = new Random();    

		for(int i =0 ;i<arr2.length;i++)
		{
			System.out.println("infinite");
			int randomNumber;
			do
			{
				System.out.println("infinite");

				randomNumber=r.nextInt(arr.length);
								
			}while(arr[randomNumber] == -1);
	
			arr2[count] = arr[randomNumber];
			arr[randomNumber] = -1;
			
			count= count+1;
		}
		
		// for( int i=0; i<arr2.length -1; i++) 
		// {
		// 	arr2[i] = i;
		// }
		for( int i=0; i<arr2.length -1 ; i++) 
		{
			System.out.println( arr2[i] );
		}

		System.out.println("test2");

		b1.setLabel( "" + arr2[0] );
		b2.setLabel( "" + arr2[1] );
		b3.setLabel( "" + arr2[2] );
		b4.setLabel( "" + arr2[3] );
		b5.setLabel( "" + arr2[4] );
		b6.setLabel( "" + arr2[5] );
		b7.setLabel( "" + arr2[6] );
		b8.setLabel( "" + arr2[7] );
		b9.setLabel( "" + arr2[8] );
	}

    event1()
	{
		method1();
		setLayout(new GridLayout(3,3,10,10));
		b1 = new Button("" + arr2[0]);
		b1.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		b2 = new Button("" + arr2[1]);
		b2.setFont(new Font("comic sans ms", Font.BOLD, 20));

		b3 = new Button("" + arr2[2]);
		b3.setFont(new Font("comic sans ms", Font.BOLD, 20));
		b4 = new Button("" + arr2[3]);
		b4.setFont(new Font("comic sans ms", Font.BOLD, 20));
		b5 = new Button("" + arr2[4]);
		b5.setFont(new Font("comic sans ms", Font.BOLD, 20));
		b6 = new Button("" + arr2[5]);
		b6.setFont(new Font("comic sans ms", Font.BOLD, 20));
		b7 = new Button("" + arr2[6]);
		b7.setFont(new Font("comic sans ms", Font.BOLD, 20));
		b8 = new Button("" + arr2[7]);
		b8.setFont(new Font("comic sans ms", Font.BOLD, 20));
		b9 = new Button("");	
		b9.setFont(new Font("comic sans ms", Font.BOLD, 20));
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);		
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
	}
	public  void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();
		if (ob == b1)
		{
			t1 = b2.getLabel();
			t2 = b4.getLabel();
			t3 = b1.getLabel();
			
			if(t1 == "" )
			{
				b1.setLabel(t1);
				b2.setLabel(t3);	
			}
			if(t2 == "" )
			{
				b1.setLabel(t2);
				b4.setLabel(t3);	
			}
		}
		if (ob == b2)
		{
			t1 = b1.getLabel();
			t2 = b3.getLabel();
			t3 = b5.getLabel();
			t4 = b2.getLabel();
			
			if(t1 == "" )
			{
				b2.setLabel(t1);
				b1.setLabel(t4);	
			}
			if(t2 == "" )
			{
				b2.setLabel(t2);
				b3.setLabel(t4);	
			}
			if(t3 == "" )
			{
				b2.setLabel(t3);
				b5.setLabel(t4);	
			}
		}
		if (ob == b3)
		{
			t1 = b2.getLabel();
			t2 = b6.getLabel();
			t3 = b3.getLabel();
			
			if(t1 == "" )
			{
				b3.setLabel(t1);
				b2.setLabel(t3);	
			}
			if(t2 == "" )
			{
				b3.setLabel(t2);
				b6.setLabel(t3);	
			}
		}
		if (ob == b4)
		{
			t1 = b1.getLabel();
			t2 = b5.getLabel();
			t3 = b7.getLabel();
			t4 = b4.getLabel();
			
			if(t1 == "" )
			{
				b4.setLabel(t1);
				b1.setLabel(t4);	
			}
			if(t2 == "" )
			{
				b4.setLabel(t2);
				b5.setLabel(t4);	
			}
			if(t3 == "" )
			{
				b4.setLabel(t3);
				b7.setLabel(t4);	
			}
		}	
		if (ob == b5)
		{	
			t1 = b2.getLabel();
			t2 = b6.getLabel();
			t3 = b4.getLabel();
			t4 = b8.getLabel();

			t5 = b5.getLabel();
			if(t1 == "" )
			{
				b5.setLabel(t1);
				b2.setLabel(t5);	
			}
			if(t2 == "" )
			{
				b5.setLabel(t2);
				b6.setLabel(t5);	
			}
			if(t3 == "" )
			{
				b5.setLabel(t3);
				b4.setLabel(t5);	
			}
			if(t4 == "" )
			{
				b5.setLabel(t4);
				b8.setLabel(t5);	
			}
		}
		if (ob == b6)
		{
			t1 = b3.getLabel();
			t2 = b5.getLabel();
			t3 = b9.getLabel();
			t4 = b6.getLabel();
			
			if(t1 == "" )
			{
				b6.setLabel(t1);
				b3.setLabel(t4);	
			}
			if(t2 == "" )
			{
				b6.setLabel(t2);
				b5.setLabel(t4);	
			}
			if(t3 == "" )
			{
				b6.setLabel(t3);
				b9.setLabel(t4);	
			}
				
		}	
		if (ob == b7)
		{
			t1 = b4.getLabel();
			t2 = b8.getLabel();
			t3 = b7.getLabel();
			
			if(t1 == "" )
			{
				b7.setLabel(t1);
				b4.setLabel(t3);	
			}
			if(t2 == "" )
			{
				b7.setLabel(t2);
				b8.setLabel(t3);	
			}
		}
		if (ob == b8)
		{
			t1 = b5.getLabel();
			t2 = b7.getLabel();
			t3 = b9.getLabel();
			t4 = b8.getLabel();
			
			if(t1 == "" )
			{
				b8.setLabel(t1);
				b5.setLabel(t4);	
			}
			if(t2 == "" )
			{
				b8.setLabel(t2);
				b7.setLabel(t4);	
			}
			if(t3 == "" )
			{
				b8.setLabel(t3);
				b9.setLabel(t4);	
			}	
			
		}	
		if (ob == b9)
		{
			t1 = b6.getLabel();
			t2 = b8.getLabel();
			t3 = b9.getLabel();
			
			if(t1 == "" )
			{
				b9.setLabel(t1);
				b6.setLabel(t3);	
			}
			if(t2 == "" )
			{
				b9.setLabel(t2);
				b8.setLabel(t3);	
			}
			
		}

		z1 = b1.getLabel();	
		x1 = Integer.parseInt(z1);

		z2 = b2.getLabel();
		x2 =Integer.parseInt(z2);

		z3 = b3.getLabel();	
		x3 = Integer.parseInt(z3);

		z4 = b4.getLabel();
		x4 =Integer.parseInt(z4);

		z5 = b5.getLabel();	
		x5= Integer.parseInt(z5);

		z6 = b6.getLabel();
		x6 =Integer.parseInt(z6);

		z7 = b7.getLabel();	
		x7 = Integer.parseInt(z7);

		z8 = b8.getLabel();
		x8 =Integer.parseInt(z8);
		
		if(x1 <x2 && x2<x3  && x3<x4 && x4<x5 && x5<x6 && x6<x7 && x7<x8)
		{
			System.out.println("WIN");
			b9.setLabel("WIN");
			b9.setBackground(Color.GREEN);
		}
	}
	
}