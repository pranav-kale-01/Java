import java.awt.*; 
import java.awt.event.*; 

public class Question7 extends Frame implements ActionListener {
    TextArea ta1 ; 
    Label l1, l2;
    double first_number, second_number;

    private boolean getSecondNumber = false;
    private boolean clearFirstNumber = true ; 
    private String operation_str; 

    public Question7() { 
        Font large = new Font("Times New Roman", Font.PLAIN , 24 );
        Font veryLarge = new Font("Times New Roman", Font.BOLD, 44 );

        Panel p1 = new Panel( );

        l1 = new Label(); 
        l2 = new Label();

        l1.setFont( large );
        l2.setFont( veryLarge );
        l1.setAlignment( 2 ); 
        l2.setAlignment( 2 );


        l2.setText("0");

        // l1.setBackground( Color.RED ); 
        // l2.setBackground( Color.BLUE );

        p1.setLayout( new GridLayout( 2, 1) );

        p1.add( l1 ); 
        p1.add( l2 );

        Panel p2 = new Panel( ); 

        p2.setLayout(  new GridLayout( 6,3 ) ); 

        // First Row
        Button btn_percent = new Button( "%" ); 
        btn_percent.addActionListener( this );
        btn_percent.setFont( large );
        
        Button btn_ce = new Button( "CE" ); 
        btn_ce.addActionListener( this );
        btn_ce.setFont( large );

        Button btn_c = new Button( "C" ); 
        btn_c.addActionListener( this ); 
        btn_c.setFont( large );

        Button btn_clear = new Button( "CLEAR" ); 
        btn_clear.addActionListener( this );
        btn_clear.setFont( large );

        p2.add( btn_percent ); 
        p2.add( btn_ce ); 
        p2.add( btn_c ); 
        p2.add( btn_clear ); 
        
        // Second Row
        Button btn_one_by_x = new Button( "1/x" ); 
        btn_one_by_x.addActionListener( this );
        btn_one_by_x.setFont( large );

        Button btn_x_square = new Button( "x2" ); 
        btn_x_square.addActionListener( this );
        btn_x_square.setFont( large );

        Button btn_two_root_x = new Button( "2\\/x" );
        btn_two_root_x.addActionListener( this ); 
        btn_two_root_x.setFont( large );

        Button btn_div = new Button( "/" ); 
        btn_div.addActionListener( this );
        btn_div.setFont( large );

        p2.add( btn_one_by_x );
        p2.add( btn_x_square ); 
        p2.add( btn_two_root_x );
        p2.add( btn_div );

        // Third row
        Button btn_7 = new Button( "7" );
        btn_7.addActionListener( this );
        btn_7.setFont( large );

        Button btn_8 = new Button( "8" );
        btn_8.addActionListener( this );
        btn_8.setFont( large );

        Button btn_9 = new Button( "9" );
        btn_9.addActionListener( this );
        btn_9.setFont( large );

        Button btn_mul = new Button( "x" );
        btn_mul.addActionListener( this );
        btn_mul.setFont( large );

        p2.add( btn_7 ); 
        p2.add( btn_8 ); 
        p2.add( btn_9 ); 
        p2.add( btn_mul );

        // Fourth Row
        Button btn_4 = new Button( "4" );
        btn_4.addActionListener( this ); 
        btn_4.setFont( large );

        Button btn_5 = new Button( "5" );
        btn_5.addActionListener( this ); 
        btn_5.setFont( large );

        Button btn_6 = new Button( "6" );
        btn_6.addActionListener( this ); 
        btn_6.setFont( large );        

        Button btn_sub = new Button( "-" );
        btn_sub.addActionListener( this ); 
        btn_sub.setFont( large );

        p2.add( btn_4 );
        p2.add( btn_5 );
        p2.add( btn_6 );
        p2.add( btn_sub );


        // Fifth Row
        Button btn_1 = new Button( "1" );
        btn_1.addActionListener( this ); 
        btn_1.setFont( large );
        
        Button btn_2 = new Button( "2" );
        btn_2.addActionListener( this ); 
        btn_2.setFont( large );
        
        Button btn_3 = new Button( "3" );
        btn_3.addActionListener( this ); 
        btn_3.setFont( large );

        Button btn_add = new Button( "+" );
        btn_add.addActionListener( this ); 
        btn_add.setFont( large );


        p2.add( btn_1 );
        p2.add( btn_2 ); 
        p2.add( btn_3 );
        p2.add( btn_add );

        // Sixth Row 
        Button btn_plus_minus = new Button( "+/-" );
        btn_plus_minus.addActionListener( this ); 
        btn_plus_minus.setFont( large );

        Button btn_0 = new Button( "0" );
        btn_0.addActionListener( this ); 
        btn_0.setFont( large );
        
        Button btn_decimal = new Button( "." );
        btn_decimal.addActionListener( this ); 
        btn_decimal.setFont( large );
        
        Button btn_equals = new Button( "=" );
        btn_equals.addActionListener( this ); 
        btn_equals.setFont( large );

        p2.add( btn_plus_minus );
        p2.add( btn_0 );
        p2.add( btn_decimal );
        p2.add( btn_equals );

        this.setLayout( new GridLayout( 2, 1) );

        this.add( p1 );
        this.add( p2 );
    }

    public void actionPerformed( ActionEvent ae ) {
        String s = ae.getActionCommand();

        if( s.equals( "0" ) || s.equals( "1" ) || s.equals( "2" ) || s.equals( "3" ) || s.equals( "4" ) || s.equals( "5" ) || s.equals( "6" ) || s.equals( "7" ) || s.equals( "8" ) || s.equals( "9" ) ) 
        { 
        
            if( this.clearFirstNumber == true ) {
                l2.setText( s ); 
                this.clearFirstNumber= false;
            }
            else {
                l2.setText( l2.getText() + s  ); 
            }

            if( this.getSecondNumber == false ) {
                this.first_number = Double.parseDouble( l2.getText() );
            }
            else{
                this.second_number = Double.parseDouble( l2.getText() );
            }   

            System.out.println( this.first_number );
            System.out.println( this.second_number );
        }
        else if( s.equals("C") ) 
        {
            this.l1.setText( "" ); 
            this.l2.setText( "0" );

            this.clearFirstNumber = true; 
            this.first_number =0;
            this.second_number =0; 
        }
        else if( s.equals("CE") ) 
        {
            this.clearFirstNumber = true ;
            this.getSecondNumber = false ;
            this.l2.setText( "0" );
            this.second_number =0 ;
        }
        else if( s.equals("=") ) {
            System.out.println("equals");
            System.out.println(first_number);
            System.out.println( second_number);
            

            if( operation_str.equals("+") ) 
            {
                l1.setText( l1.getText() + l2.getText() + " = " + ( first_number + second_number) ); 
                l2.setText( "" + (first_number + second_number) );

                this.second_number = first_number + second_number;
                
            }
            else if( operation_str.equals( "-" ) ) {
                l1.setText( l1.getText() + l2.getText() + " = " + ( second_number - first_number ) ); 
                l2.setText( "" + (second_number - first_number ) );

                this.second_number = second_number - first_number;
            }
            else if( operation_str.equals( "x" ) ) {
                l1.setText( l1.getText() + l2.getText() + " = " + ( first_number * second_number) ); 
                l2.setText( "" + (first_number * second_number) );

                this.second_number = first_number * second_number;
            } 
            else if( operation_str.equals("/") ) {
                l1.setText( l1.getText() + l2.getText() + " = " + ( second_number / first_number ) ); 
                l2.setText( "" + (second_number / first_number ) );

                this.second_number = second_number / first_number;
            }
            this.getSecondNumber = true ;
            this.clearFirstNumber = true ;
        }
        else
        { 
            if( s.equals( "" ) ) {
                
            }
            else {
                if( this.getSecondNumber == false ){
                    this.operation_str = s ;

                    l1.setText( l2.getText() + " " + s ); 
                    this.getSecondNumber = true;    
                    this.clearFirstNumber = true; 
                }
                else {
                    this.operation_str = s; 

                    l1.setText( l2.getText() + " " + s );
                    this.getSecondNumber = false; 
                }
            }
        }

    }

    public static void main( String ar[] ){
        Question7 q7 = new Question7(); 
        q7.setSize( 400, 700 );
        q7.setVisible( true );
    }
}