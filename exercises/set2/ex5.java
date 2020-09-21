import java.util.Scanner;

class PasswordChecker
{
	public static void main(String args[])

	{
		int digitCount=0;
		int lowerCount=0;
		int upperCount=0;
		int spaceCount=0;


    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter your password:");
    String password = scanner.nextLine();

    System.out.println(password);

		//testing the password agaist the ciritea
		int length = password.length();
		if (length < 8){
			System.out.println("Password is too short");
			return;
		}
		else{
			System.out.println("Password length is fine");
			char[] chars = password.toCharArray();
			for (int i =0; i < chars.length; i++){

				boolean upper = Character.isUpperCase(chars[i]);
				if (upper == true)
					upperCount++;

				boolean lower= Character.isLowerCase(chars[i]);
					if (lower == true)
						lowerCount++;

    		boolean digit= Character.isDigit(chars[i]);
				if (digit == true)
					digitCount++;

				boolean space= Character.isSpace(chars[i]);
				if (space == true)
					spaceCount++;
			}
			System.out.println(upperCount+" uppercase");
			System.out.println(lowerCount+" lowercase");
			System.out.println(digitCount+" digits");
			System.out.println(spaceCount+" whitespace");

			if ((upperCount >0) && (lowerCount >0) && (digitCount >0) && (spaceCount == 0)){
				System.out.println("Password is OK");
			}
			else
				System.out.println("Password is invalid");
		}
  }
}
