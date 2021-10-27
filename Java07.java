import java.util.Scanner; 

class Java07 {
    public static void main(String ar[] ) {
        int N,D; 

        // creating a new object of Scanner 
        Scanner sc = new Scanner( System.in );

        System.out.println("N : ") ;
        N = sc.nextInt( );

        System.out.println("D: "); 
        D = sc.nextInt( );

        int power = 1;
        int temp = N ;

        int increment = 0;

        while( temp != 0 ) {
            int rem = temp % 10;
        
            System.out.println( "rem " + rem );
            System.out.println( "power " + power + "\n" );

            if( rem == D ) {
                System.out.print( rem );

                while( temp != 0 ) {
                    rem = temp % 10;
                    System.out.print( rem );

                
                    power = power * 10;
                    temp = temp / 10;        
                }
            }

            power = power * 10;
            temp = temp / 10;
        }    

        System.out.println( increment );  
    }
}