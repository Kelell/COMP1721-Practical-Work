import java.util.Scanner;

class ConvertTime {
   public static void main (String[] args)
   {
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("Please enter the elapsed time in seconds:");
	   int seconds = scanner.nextInt();


     int timeHours = seconds / 3600;
     int timeMins = (seconds % 3600) / 60;
     int timeSecs = seconds % 60;

     String timeString = String.format("%02d Hour %02d Minutes %02d Seconds ", timeHours, timeMins, timeSecs);

     System.out.println(timeString);
   }
}
