// This Program figures out how much a driver owes when leaving a parking deck
// There are different parameters that may affect the price, such as duration,
// day of the week, time of day, being a member of the school and others.

import java.util.Scanner;
import java.lang.Math;

public class ParkingDeck
{
	public static void main(String[] args)
	{
		Driver drive = new Driver();

		Scanner input = new Scanner(System.in);
		// Query driver on day of the week for free weekend parking
		System.out.println("Enter today's day of the week");
		System.out.print("(Sunday - 0, Monday - 1, Tuesday - 2, Wednesday - 3, Thursday - 4, Friday - 5, or Saturday - 6) : ");
		int day = input.nextInt();
		if (day == 0 || day == 6)
		{
			System.out.println("Parking on the Weekends is free.");
			System.out.println("Thank you for using our Parking Services!");
		}
		
		else
		{
			System.out.println("Do you have a permit? T/F ");
			boolean permit = input.nextBoolean();
			
			if (permit == true)
			{
				System.out.println("Permit accepted");
				System.out.println("Thank you for using our Parking Services!");
			}
			else
			{
				// Query driver on duration of stay in parking deck
				System.out.println("Enter entry hour from 0 - 23: ");
				int enHr = input.nextInt();
				System.out.println("Enter entry minute from 0 - 59: ");
				int enMin = input.nextInt();
				System.out.println("Enter exit hour from 0 - 23: ");
				int exHr = input.nextInt();
				System.out.println("Enter exit minute from 0 - 59: ");
				int exMin = input.nextInt();
				System.out.println("Are you a member of the school? (Faculty or Student) T/F ");
				boolean member = input.nextBoolean();

				Driver drive1 = new Driver(enHr, enMin, exHr, exMin, member);
				
				drive1.calcDuration(enHr, enMin, exHr, exMin);
				drive1.checkEarly(enHr, enMin, exHr, exMin);
				drive1.calcFee(enHr, enMin, exHr, exMin, member);

				System.out.printf("Your duration was : %d minutese\n", drive1.getDuration());
				System.out.printf("Early? %b\n", drive1.early());
				System.out.println("Your fee is $" + drive1.getFee());
				System.out.println("Thank you for using our Parking Services!");
			}
		}
	}
}