// single line comment 
/* 
    multiline comment 
*/ 
//* java doc comment wap in Java to print hello msg @pranav 

import java.util.Scanner;


public class Java01 { 
    public static void Main(String ar[] ) {
        // creating new oject of Scanner
        Scanner sc = new Scanner( System.in ); 

        System.out.println("Enter a integer value :");
        int number = sc.nextInt();


        System.out.println("The entered number is " + number );
    }
}