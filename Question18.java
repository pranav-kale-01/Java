import java.awt.*; 
import java.awt.event.*; 
import java.util.*;

class TopPanel extends Panel {
    private Label[] topLabels; 
    Tube[] tubes;

    public TopPanel( int size , Tube[] tubes ) {
        this.tubes = tubes;
        this.setLayout( new GridLayout( 1, size, 20, 0) );

        topLabels = new Label[ size+1 ];

        for( int i=0; i<size+1; i++ ) {
            Label l1 = new Label();
            topLabels[i] = l1;
            add( l1 );
        }
    }

    public Label[] getTopLabels() {
        return this.topLabels;
    }

    public void setLabelAt( int index, Button b) {
        topLabels[index].setBackground( b.getBackground() ) ;
    }

    public int setButtonAt( int index, Label l ) {
        return tubes[index].push( l.getBackground() );
    }

    public Button popElementFrom( int tube_ind ) {
        return tubes[tube_ind].pop();
    }

    public boolean checkIfWon() {
        for( Tube t : tubes ) {
            if( !t.checkIfSame() ){
                return false;
            }
        }
        return true;
    }
}

class myDialog extends Dialog{
    public myDialog( Frame currentFrame ) {
        super( currentFrame );

        this.setSize( 300, 200 );
        this.setLayout( null );
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent we ) {
                dispose();
            }
        }); 
        
        Label l = new Label("You Won!");
        l.setBounds( 20, 0, 300, 200 );
        l.setFont( new Font("Times New Roman", Font.BOLD, 24 ) );
        add( l );

        this.setVisible( true );
    }
}

class Tube extends Panel{ 
    Frame currentFrame;
    TopPanel topPanel;
    Color elements[];
    Button btns[];
    int size=0; 
    int top=-1;
    int id;

    class ButtonAction implements ActionListener {
        int id; 

        public ButtonAction( int id) {
            this.id = id;
        }

        public void actionPerformed( ActionEvent ae ) {
            // checking if the player won
            if( topPanel.checkIfWon() ) {
                
                myDialog md = new myDialog( currentFrame );
                return;
            }      

            // checking if any of the topLabels have any element 
            Label[] arr = topPanel.getTopLabels();
            Label currentLabel;

            for( Label i : arr ) {
                // checking any of the Label has a color other than null
                if( ! i.getBackground().equals( Color.WHITE ) ) {
                    // if there's is an Label with color, this means we have to perform push operation
                    int result = topPanel.setButtonAt( id, i );
                    if( result != 1 ) {
                        currentLabel = new Label();
                        i.setBackground( null );
                    }

                    if( topPanel.checkIfWon() ) {
                        myDialog md = new myDialog( currentFrame );
                    }        
                    return;
                }
            }   

            // else we have to perform pop operation
            currentLabel = new Label();
            
            Button b = topPanel.popElementFrom( id ); 
            
            if( b == null ) {
                return; 
            }

            currentLabel.setBackground( b.getBackground() );
            topPanel.setLabelAt( id, (Button) b );

            b.setBackground( null );
     
        }
    }

    public Tube( int id, int size, TopPanel topPanel, Frame currentFrame ) {
        this.id = id;
        this.size = size;
        this.topPanel = topPanel;
        this.currentFrame = currentFrame;
        this.setLayout( new GridLayout( size, 1, 10, 10) );

        btns = new Button[size]; 
        elements = new Color[size];

        for( int i=0; i< size; i++ ) {
            Button btn = new Button( );
            btn.addActionListener( new ButtonAction( id ) );

            btns[i] = btn;
        }

        for( int i=size-1; i>=0; i-- ) {
            add( btns[i] );
        }
    }

    public int push( Color element ) {
        // checking for overflow condition
        if( top < size-1 ) {
            top++;
            elements[top] = element; 
            btns[top].setBackground( element );

            return 0;
        }
        else {
            return 1;  
        }
    }

    public Button pop() { 
        Button ele = null ;

        // checking for underflow condition 
        if( top >= 0 ) {
            ele = btns[top];
            elements[top] = null;
            top--;
        }

        return ele;
    }

    public boolean checkIfSame() {
        Color c = elements[0];

        if( c == null ) {
            return true ;
        }

        for( int i=1; i<elements.length; i++ ) {
            if( !c.equals( elements[i]) ) {
                return false;
            }
        }

        return true;
    }  
}

public class Question18 extends Frame {
    Tube[] tubes;
    Color[] colors;
    Color[] arr;
    int size;

    public Question18() {
        // creating object of class Scanner
        Scanner sc = new Scanner( System.in );
        
        System.out.println("Enter the size of the array: ");
        this.size = sc.nextInt();

        tubes = new Tube[size+1];
        colors = new Color[size];
        arr = new Color[size*size];

        // getting all the Colors 
        for( int i=0 ; i<size; i++ ) {  
            System.out.println("Enter a color Name: ") ;
            String color_name = sc.next();
            
            colors[i] = toColor( color_name );
        }

        // setting the array of the colors 
        for( int i=0, temp=0; i<size; temp++  ) {
            arr[temp] = colors[i];
            if( (temp+1)%size == 0 ) {
                i++;
            }
        }

        this.setLayout( null );

        // setting the top Panel
        TopPanel topPanel = new TopPanel( size, tubes );
        
        topPanel.setBounds( 100, 0, 115*(size+1), 130 );
        add( topPanel ); 

        for( int i=0 ; i<size+1; i++ ) {
            tubes[i] = new Tube(i, size, topPanel, this);
            tubes[i].setBounds( 100+(120*i), 220, 100, (100*size) );
            add(tubes[i]);
        }

        setRandom();    
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

    public Color toColor( String color ) { 
        String out="";

        if( color.equalsIgnoreCase("blue") ) {
            return Color.BLUE;
        } 
        else if ( color.equalsIgnoreCase("red") ) {
            return Color.RED;
        } 
        else if( color.equalsIgnoreCase("green") ) {
            return Color.GREEN;
        }
        else if( color.equalsIgnoreCase("orange") ) { 
            return Color.ORANGE;
        }
        else {
            return Color.WHITE;
        }
    }

    public static void main(String ar[] ) { 
        Question18 q = new Question18(); 
        q.setSize( 800, 1000 );
        q.setVisible( true );
    }
}