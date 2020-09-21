import java.util.Scanner;

class Discriminant
{
	public static void main(String args[])

	{

		double discrim, firstRoot, secondRoot;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the b value ");
    double b = scanner.nextDouble();

    System.out.print("Please enter the a value ");
    double a = scanner.nextDouble();

		System.out.print("Please enter the c value  ");
    double c = scanner.nextDouble();

		discrim = Math.pow(b, 2)-4*(a*c);

	   // selection based on the result of the discriminant
		 if (discrim > 0) {
			 firstRoot = ((-b)+Math.sqrt(discrim))/(2*a);
			 secondRoot = ((-b)-Math.sqrt(discrim))/(2*a);
			 String timeString = String.format("This equation has two real roots: %f  and %f ", firstRoot, secondRoot);
			  System.out.println(timeString);
		 }

		 else if (discrim < 0 ){
			 System.out.println("This equation has no real roots.");
		 }

		 else{
			firstRoot = ((-b)+Math.sqrt(discrim))/(2*a);
			 String timeString = String.format("This equation has one real root: %f ", firstRoot);
			 System.out.println(timeString);
		 }

	}
}
