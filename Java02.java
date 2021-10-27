import java.util.Scanner; 

public class Java02 {
	static int calcDivision( int n1,int n2 ) {
		return n1 / n2; 				
	}

	public static void main(String ar[] ) { 
		int n1, n2; 

		Scanner sc = new Scanner( System.in ); 

		System.out.println("Enter the first integer value :" ); 
		n1 = sc.nextInt(); 

		System.out.println("Enter the seond integer value :"); 
		n2 = sc.nextInt(); 

		int result = calcDivision( n1, n2 ); 

		System.out.println("Division is : " + result ); 
	}
}