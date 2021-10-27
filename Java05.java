import java.awt.*; 

public class Java05 extends Frame { 
    public Java05( ) {
        System.out.println( "PLAIN : " +  Font.PLAIN );
        System.out.println( "BOLD : " +  Font.BOLD );
        System.out.println( "ITALIC : " +  Font.ITALIC );
        System.out.println( "BOLD + ITALIC : " +  ( Font.BOLD | Font.ITALIC ) ); 
    }

    public static void main( String ar[] ) {
        Java05 j5 = new Java05();
    }
}