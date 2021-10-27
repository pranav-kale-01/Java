import java.util.*; 
import java.io.DataInputStream; 

class Java04 {
    public static boolean lexicographicallySort( String s1, String s2 ) {
        for( int j=0 ; j< ( s1.length() > s2.length() ? s2.length() : s1.length() ) ; j++ ){
            if( s1.charAt(j) > s2.charAt(j) ) {
                return true; 
            }
        }
        return false; 
    }

    public static String[] solution( ) throws java.io.IOException {
        // creating new object of DataInputStream
        DataInputStream dis = new DataInputStream( System.in ); 
        
        String inp = dis.readLine();
        int limit = Integer.parseInt( dis.readLine() );

        String[ ] result = inp.split(" ") ;

        // creating a new HashMap
        HashMap<String, Integer> elements = new HashMap<String, Integer>(); 

        // intializing the map with all the unique elements as key and 0 as value
        for( String i : result ) {
            elements.put( i , 0 );
        }

        // getting the count of repitition for all the elements
        for( int i=0 ; i< result.length ; i++ ){
            elements.put( result[i], elements.get( result[i] ) + 1 ); 
        }

        // emptying the input list and using it to display the result
        result = new String[elements.size()];

        int count= 0; 

        // checking which elements are repeated more than the limit
        for( HashMap.Entry mapElement : elements.entrySet() ) {
            if( Integer.parseInt( mapElement.getValue().toString() ) >= limit ) {
                result[count] = mapElement.getKey().toString();
                count++;  
            }
        }

        // lexicographically sorting the result String array
        for( int i=0 ; i< result.length-1 ; i++ ){
            if( result[i+1] == null ) {
                break; 
            }

            if( lexicographicallySort( result[i], result[i+1] ) ) {
                String temp = result[i] ;
                result[i] = result[i+1];
                result[i+1] = temp; 
            }
        }

        return result;    
    }

    public static void main( String ar[] ) throws java.io.IOException{
        String[] result = solution(); 

        for( String temp : result ){
            if( temp == null ) break ;
            System.out.print( temp + " " );
        }
    }
}