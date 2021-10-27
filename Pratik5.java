import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class ballsort extends Frame implements ActionListener
{
	Label l1,l2,l3,l4,l5;
	TextField tz,t11,t12,t13,t14,t15,t21,t22,t23,t24,t25,t31,t32,t33,t34,t35,t41,t42,t43,t44,t45,t51,t52,t53,t54,t55; 
	Button b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
	int[] arr1={1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4};
	int[] arr2=new int[16];	
	int count =0;
	String a,b,c,d;
	String z = "";
	public void method1()
	{
		Random r=new Random();        	
		for(int i =0 ;i<arr1.length;i++)
		{
			int randomNumber;
			do
			{
				randomNumber=r.nextInt(arr1.length);				
			}while(arr1[randomNumber] == -1);
	
			arr2[count] = arr1[randomNumber];
			arr1[randomNumber] = -1;
			count= count+1;
		}
		System.out.println(arr1.length);
		for( int i=0; i<arr2.length; i++) 
		{
			System.out.println( arr2[i] + "" );
		}
      	}	

	public ballsort()		
	{
		method1();
		Color co = new Color(224,224,224);
		setLayout(new GridLayout(7,5,20,20));
		l1 = new Label("");
		l1.setBackground(co);
		l2 = new Label("Obtained");
		l2.setBackground(co);
		l2.setFont(new Font("comic sans ms", Font.BOLD, 20));
		l3 = new Label("");
		l3.setBackground(co);
		l4 = new Label("");
		l4.setBackground(co);

		tz = new TextField();
		tz.setFont(new Font("comic sans ms", Font.BOLD, 24));

		t11 = new TextField();
		t11.setText("" + arr2[0]);
		t11.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t12 = new TextField();
		t12.setText("" + arr2[1]);
		t12.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t13 = new TextField();
		t13.setText("" + arr2[2]);
		t13.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t14 = new TextField();
		t14.setText("" + arr2[3]);
		t14.setFont(new Font("comic sans ms", Font.BOLD, 24));


		t15 = new TextField();
		t15.setFont(new Font("comic sans ms", Font.BOLD, 24));


		t21 = new TextField();
		t21.setText("" + arr2[5]);
		t21.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t22 = new TextField();
		t22.setText("" + arr2[6]);
		t22.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t23 = new TextField();
		t23.setText("" + arr2[7]);
		t23.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t24 = new TextField();
		t24.setText("" + arr2[8]);
		t24.setFont(new Font("comic sans ms", Font.BOLD, 24));

		t25 = new TextField();
		t25.setFont(new Font("comic sans ms", Font.BOLD, 24));


		t31 = new TextField();
		t31.setText("" + arr2[10]);
		t31.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t32 = new TextField();
		t32.setText("" + arr2[11]);
		t32.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t33 = new TextField();
		t33.setText("" + arr2[12]);
		t33.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t34 = new TextField();
		t34.setText("" + arr2[13]);
		t34.setFont(new Font("comic sans ms", Font.BOLD, 24));

		t35 = new TextField();
		t35.setFont(new Font("comic sans ms", Font.BOLD, 24));
		

		t41 = new TextField();
		t41.setText("" + arr2[4]);
		t41.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t42 = new TextField();
		t42.setText("" + arr2[9]);
		t42.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t43 = new TextField();
		t43.setText("" + arr2[14]);
		t43.setFont(new Font("comic sans ms", Font.BOLD, 24));
		t44 = new TextField();
		t44.setText("" + arr2[15]);
		t44.setFont(new Font("comic sans ms", Font.BOLD, 24));

		t45 = new TextField();
		t45.setFont(new Font("comic sans ms", Font.BOLD, 24));


		Color co1 = new Color(255,153,55);
		b11 = new Button("PUSH");
		b11.setBackground(co1);	
		b11.setFont(new Font("comic sans ms", Font.BOLD, 18));

		b12 = new Button("PUSH");
		b12.setBackground(co1);	
		b12.setFont(new Font("comic sans ms", Font.BOLD, 18));
	
		b13 = new Button("PUSH");
		b13.setBackground(co1);	
		b13.setFont(new Font("comic sans ms", Font.BOLD, 18));

		b14 = new Button("PUSH");
		b14.setBackground(co1);	
		b14.setFont(new Font("comic sans ms", Font.BOLD, 18));

		b15 = new Button("PUSH");
		b15.setBackground(co1);	
		b15.setFont(new Font("comic sans ms", Font.BOLD, 18));


		Color co2 = new Color(102,255,178);
		b16 = new Button("POP");
		b16.setBackground(co2);	
		b16.setFont(new Font("comic sans ms", Font.BOLD, 18));
		
		b17 = new Button("POP");
		b17.setBackground(co2);	
		b17.setFont(new Font("comic sans ms", Font.BOLD, 18));

		b18 = new Button("POP");
		b18.setBackground(co2);	
		b18.setFont(new Font("comic sans ms", Font.BOLD, 18));
		
		b19 = new Button("POP");
		b19.setBackground(co2);	
		b19.setFont(new Font("comic sans ms", Font.BOLD, 18));

		b20 = new Button("POP");
		b20.setBackground(co2);	
		b20.setFont(new Font("comic sans ms", Font.BOLD, 18));
		
		add(l1);
		add(l2);
		add(tz);
		add(l3);
		add(l4);
		
		add(t11);
		add(t12);
		add(t13);
		add(t14);
		add(t15);
		add(t21);
		add(t22);
		add(t23);
		add(t24);
		add(t25);
		add(t31);
		add(t32);
		add(t33);
		add(t34);
		add(t35);
		add(t41);
		add(t42);
		add(t43);
		add(t44);
		add(t45);

		add(b11);
		add(b12);
		add(b13);
		add(b14);
		add(b15);
		add(b16);
		add(b17);
		add(b18);
		add(b19);
		add(b20);

		b16.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();
		if (ob == b16)
		{
			a = t11.getText();
			if(a.length() != 0 )
			{
				tz.setText(a);
				t11.setText("");
			}
			else if (a.length() == 0 && b.length() != 0 )
			{
                tz.setText(b);
                t21.setText("");
			}
            else if( b.length() == 0 && c.length() != 0 ) { 
                tz.setText(c);
                t31.setText("");
            } 
            else {
                tz.setText(d);
                t41.setText("");
            }

			a = t11.getText();
			b = t21.getText();
			c = t31.getText();
			if (a.length() != 0 )
			{
				if(b.length() != 0 )
				{
					if(c.length() != 0 )
					{
						tz.setText(c);
						t31.setText("");
					}
				}
			}
			a = t11.getText();
			b = t21.getText();
			c = t31.getText();
			d = t41.getText();

			if(a.length() != 0 )
			{
				if(b.length() != 0 )
				{
					if(c.length() != 0 )
					{
						if(d.length() != 0 )
						{
							tz.setText(d);
							t41.setText("");
						}
					}
				}
			}
		}	
	}
	public static void main(String arr[])
	{
		ballsort bs1 = new ballsort();
		bs1.setSize(600,600);
		bs1.setVisible(true);
		Color co = new Color(224,224,224);
		bs1.setBackground(co);
		
	}
}