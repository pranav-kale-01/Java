import java.util.*; 
import java.awt.*;
import java.awt.event.*;

public class Question16 extends Frame { 
    Tube[] tubes;
    String[] arr;
    Label topLabel;
    int size;
    String color_name[] = {"BLUE","GREEN","RED","ORANGE"}; 
    Color colors[] = {};

    class Tube extends Panel {
        String[] elements; 
        Label[] eles;
        String obtained="";
        int size=0; 
        int top=-1;

        public Tube() {
            super();

            size=1;
            elements = new String[1];
        }

        public Tube( int size ) {
            super();
            
            this.setFont( new Font("Times New Roman", Font.PLAIN, 23 ) );

            this.size = size;
            elements = new String[size];
            eles = new Label[size];

            int i=0,j;
            int dimension = 100;

            this.setLayout( null );

            Label[] temp = new Label[size];

            for( j=size-1; j>=0; j-- ) {
                Label lb1 = new Label("");
                eles[j] = lb1;
                temp[j]= lb1;
                temp[j].setBounds(0,dimension*(j+1),dimension,dimension);
                add( temp[j] );
            }

            i+=2;

            // push Button
            Button pushBtn= new Button("Push"); 
            pushBtn.setBounds(0,dimension*(size+1), dimension, 50 );
            pushBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent ae ) {
                    push( topLabel.getText() );
                }
            });

            add( pushBtn );

            i++;

            // pop Button 
            Button popBtn = new Button("Pop");
            popBtn.setBounds(0,dimension*(size+2), dimension, 50 );
            popBtn.addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent ae ) {
                    String res = pop();

                    if( res == "" ) {
                        topLabel.setBackground( null );
                    }
                    else{
                        int index=0 ; 

                        for( int i=0 ; i < color_name.length; i++ ) {
                            if( color_name[i].equalsIgnoreCase( res ) ) {
                                index++; 
                            }
                        }

                        topLabel.setBackground( colors[index] );
                    }
                }
            });

            add( popBtn );
        }

        public int push( String element ) {
            // checking for overflow condition
            if( top < size-1  ) {
                top++;
                elements[top] = element; 
                eles[top].setText( element );
                topLabel.setText("");

                obtained="";

                return 0;
            }
            else {
                return 1;  
            }
        }

        public String pop() {
            String ele=""; 
            // checkinf for underflow condition 
            if( top >= 0 ) {
                if( topLabel.getText().equals("") ) {
                    ele = elements[top];
                    obtained = elements[top];
                    eles[top].setText( "" );
                    top--;
                }
                else {
                    ele = topLabel.getText();
                }
            }
            else {
                System.out.println("Stack UnderFlow");
            }

            return ele;
        }

        public void display() {
            // displaying all the elements 
            for( int i=0 ; i <= top ; i++ ) {
                System.out.print( elements[i] + ",  ") ;
            }
            System.out.println("");
        }

        public boolean checkIfSame() {
            boolean result = true;

            String temp = elements[0];

            if( temp == null ) {
                return true;   
            }

            for( int i=1; i<elements.length; i++ ) {
                if( elements[i] == null ) {
                    result = false;
                    break;
                }
                            
                if( !temp.equalsIgnoreCase(elements[i]) ) {
                    result = false;
                    break;
                }
            }

            return result;
        }
    }

    public Question16() {
        // creating new object of class Scanner
        Scanner sc = new Scanner( System.in );
        
        System.out.println("Enter the Size of the Tube :") ;
        size = sc.nextInt();

        this.setLayout( null ) ;        

        Panel p1 = new Panel();
        p1.setBounds( 50, 100, 600, 900 );
        p1.setLayout( new GridLayout( 1, size+1, 10, 0) );

        // adding the top Panel that holds elements when they are poped
        topLabel = new Label(); 
        topLabel.setFont( new Font("Times New Roman", Font.PLAIN, 23 ) );
        topLabel.setBackground( Color.RED );
        topLabel.setBounds( 250, 50, 100, 100 );
        add( topLabel );

        // initializing arrays according to provided size
        tubes = new Tube[size+1];

        for( int i=0; i<=size; i++ ) {
            tubes[i] = new Tube( size );
            p1.add( tubes[i] );
        }

        String colors[] = new String[size];

        // taking colors as input 
        for( int i=0 ; i<size; i++ ){
            System.out.println("Enter a Color Name :") ;
            String color = sc.next();

            colors[i] = color; 
        }


        arr = new String[ size * size ];

        for( int i=0, temp=0; i<size; temp++  ) {
            arr[temp] = colors[i];
            if( (temp+1)%size == 0 ) {
                i++;
            }
        }

        setRandom( );

        add(p1);

        this.setVisible(true);
    }

    public void setRandom(  ) {
        // creating new object of Random
        Random rn = new Random( );

        for( int i=0; i<size*size ; ) {
            // iterating over arr and putting the values randomly in any one of the avaialble tubes
            int rnd = rn.nextInt( size );

            int result = tubes[rnd].push( arr[i] );
            if( result == 0 ) {
                i++;
            }
        }
    }

    public void startGame() {
        Scanner sc = new Scanner( System.in );
        int count, from, to;

        while( !checkIfWon() ) {
            count=0;

            System.out.print("\n\n\n");
            for( Tube t : tubes ) {
                System.out.print( "Tube " + count + " - ");
                t.display();
                count++;
            }

            System.out.println("From which tube you want to move? :" );
            from = sc.nextInt();

            try{ 
                String element = tubes[from].pop();

                if( element == "" ) {
                    System.out.println("No more elements here!");
                    continue;
                }

                System.out.println("To which tube you want to move? : ");
                to = sc.nextInt();

                int result = tubes[to].push( element );

                if( result == 1 ) {
                    System.out.println("Can't insert element here!");
                    tubes[from].push( element );
                }
                else { 
                    if( checkIfWon() ){
                        return;
                    }
                    continue;
                }
            }
            catch( Exception e ) {
                e.printStackTrace();
            }
        }
        if( checkIfWon() ) {
            System.out.println("You Won!");
        }
    }

    public boolean checkIfWon() {
        boolean flag = true ;

        // checking if won
        for( Tube i : tubes ) {
            if( i.top >= 0 ) {
                if( !i.checkIfSame() ) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public static void main( String ar[] ) {
        Question16 j = new Question16();
        // j.init();
        // j.startGame();
        j.setSize( 800, 1000 );
    }
}