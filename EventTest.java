import java.awt.*;
import java.awt.event.*; 

class EventTest implements ActionListener, KeyListener {
	TextField tf1, tf2, tf3; 

	public EventTest() {
		Frame f1 = new Frame(); 
		
		f1.setSize( 400, 400 ); 
		f1.setVisible( true) ; 
		f1.setTitle( "Event Test");
		f1.setLayout( new FlowLayout() );

		tf1 = new TextField( 15 ); 
		tf2 = new TextField( 15 );
		tf3 = new TextField( 15 ); 
		Button btn1 = new Button("abc");
		Button btn2=new Button("xyz");

		tf3.addKeyListener( this );

		btn1.addActionListener( new ActionListener() {

			public void actionPerformed(ActionEvent ae)
			{
				System.out.println(ae.toString());
				int c=Integer.parseInt(tf1.getText())+Integer.parseInt(tf2.getText());
				System.out.println( btn1.toString() );

				tf3.setText(""+c);
				System.out.println("Hello Pranav");
			}
		});

		f1.add( tf1 ); f1.add( tf2 ); f1.add( btn1 ); f1.add( tf3 ); f1.add(btn2);	 
	}

	public void actionPerformed( ActionEvent ae  ) {
		String s1 = tf1.getText();
		String s2 = tf2.getText(); 

		Integer addition = Integer.parseInt( s1 ) + Integer.parseInt( s2 ) ;

		// setting the value to tf3 
		System.out.println( ae.toString() );

		tf3.setText( addition.toString() ); 
		System.out.println("Hello World"); 
	}  

	public void keyPressed( KeyEvent ke ){
	
		// setting the value to tf3 
		System.out.println( ke.toString() );
	}

	public void keyReleased( KeyEvent ke ) {
		System.out.println("released") ;
		System.out.println( ke.toString() );
	}
	public void keyTyped (KeyEvent ke) {    
		System.out.println("typed");
		System.out.println( ke.toString() );
	}

	public static void main(String ar[]) {
		EventTest obj = new EventTest(); 
	}    
}

// public class EventTest extends Frame implements ActionListener, KeyListener {
// 	TextField tf1, tf2, tf3; 

// 	public EventTest() { 
// 		this.setLayout( new FlowLayout() );

// 		tf1 = new TextField( 15 ); 
// 		tf2 = new TextField( 15 );
// 		tf3 = new TextField( 15 ); 
// 		Button btn1 = new Button("abc");
// 		Button btn2=new Button("xyz");

// 		tf3.addKeyListener( this );

// 		btn1.addActionListener( new ActionListener() {

// 			public void actionPerformed(ActionEvent ae)
// 			{
// 				System.out.println(ae.toString());
// 				int c=Integer.parseInt(tf1.getText())+Integer.parseInt(tf2.getText());
// 				System.out.println( btn1.toString() );

// 				tf3.setText(""+c);
// 				System.out.println("Hello Pranav");
// 			}
// 		});

// 		add( tf1 ); add( tf2 ); add( btn1 ); add( tf3 );add(btn2);
// 	}

// 	public static void main( String ar[] ) {
// 		EventTest et = new EventTest(); 
// 		et.setSize( 400, 400 ); 
// 		et.setVisible( true) ; 
// 		et.setTitle( "Event Test"); 
// 	}
// }
