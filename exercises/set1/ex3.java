import java.util.Scanner;
class Distance
{
	public static void main(String args[])

	{
		double dis;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first point's x coordinate ");
    double x1 = scanner.nextDouble();


    System.out.print("Enter the first point's y coordinate");
    double y1 = scanner.nextDouble();


		System.out.print("Enter the second point's x coordinate ");
    double x2 = scanner.nextDouble();


    System.out.print("Enter the second point's y coordinate");
    double y2 = scanner.nextDouble();


	        dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

  	        System.out.println("distance between the point"+"("+x1+","+y1+") and "+"("+x2+","+y2+") is: "+dis);

	}
}
