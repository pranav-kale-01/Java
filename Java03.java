import java.io.DataInputStream; 

class Java03 {
    public static int solution( ) throws java.io.IOException {
        DataInputStream dis = new DataInputStream( System.in ); 

        int n = Integer.parseInt( dis.readLine() );
        int[] arr = new int[n];  

        for( int i =0 ; i<n ; i++ ) {
            arr[i] = Integer.parseInt( dis.readLine() ); 
        }

        // sorting the array using bubble sort
        for( int i=0 ; i<n; i++ ){
            for( int j=0 ; j < n-1 ; j++ ) {
                if( arr[i] < arr[j] ) {
                    int temp = arr[i] ;
                    arr[i] = arr[j]; 
                    arr[j] = temp;
                }
            }
        }

        // getting counts of all the numbers
        int k = -1, ele = -1 ; 
        int[] arr2 = new int[n];

        for( int i=0; i<n ; i ++ ){
            if( arr[i] != ele ) {
                ele = arr[i];
                k++;
                arr2[k] = 0;                  
            }
            arr2[k] += 1; 
        }
        
        // finding the greatest differnece between the counts of all products 
        int result =0;  
        for( int i=0; i<n-1 ; i++ ){
            if( arr2[i] == 0 ) {
                break;
            } 

            int temp = arr2[i+1] - arr2[i] ;
            if( temp > result ) {
                result = temp; 
            }
        }

        return result;
    }

    public static void main(String ar[] ) throws java.io.IOException    { 
        int result = solution();

        System.out.println( "Result - " + result );
    }
}