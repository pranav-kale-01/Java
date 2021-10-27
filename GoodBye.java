import java.util.Scanner; 

class HelloWorld {
		try 
		{
			int result = n1/ n2; 
			System.out.println("Result is :" + result );
		}
		catch( AarithmeticException e ) {
			System.out.println("Denominator is 0, cannot perform division! ") ; 
		}
	}

	public static void main( String ar[] ) {
		int n1, n2; 

		// creating a new object of Scanner 
		Scanner sc = new Scanner();

		System.out.println("Please Enter two Integer values : "); 

		// taking input for n1 and n2 
		n1 = sc.nextInt(); 

		n2 = sc.nextInt(); 

		division( n1, n2 ); 
