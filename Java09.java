import java.util.*; 

class Tube {
    String[] elements; 
    int size=0; 
    int top=-1;

    public Tube() {
        size=1;
        elements = new String[1];
    }

    public Tube( int size ) {
        this.size = size;
        elements = new String[size];
    }

    public int push( String element ) {
     

        // checking for overflow condition
        if( top < size-1 ) {
            top++;
            elements[top] = element; 
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
            ele = elements[top];
            top--;
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

public class Java09 { 
    Tube[] tubes;
    String[] colors, arr;
    int size;

    public void init() {
        // creating new object of class Scanner
        Scanner sc = new Scanner( System.in );
        
        System.out.println("Enter the Size of the Tube :") ;
        size = sc.nextInt();

        // initializing arrays according to provided size
        tubes = new Tube[size+1];

        for( int i=0; i<=size; i++ ) {
            tubes[i] = new Tube( size );
        }

        colors = new String[size];

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
        Java09 j = new Java09();
        j.init();
        j.startGame();
    }
}