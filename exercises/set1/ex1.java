import java.util.Scanner;

class ConvertDistance {
   public static void main (String[] args)
   {
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("Enter the distance in km:");
	   double distanceKm = scanner.nextDouble();
	   double distanceMiles = distanceKm*0.625;
     System.out.printf("%.3f miles = %.3f km%n",
 distanceMiles, distanceKm);
   }
}
