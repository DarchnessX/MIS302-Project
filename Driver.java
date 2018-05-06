// This is the driver class

import java.util.Scanner;
import java.lang.Math;

public class Driver
{
	// Private vars
	private int enHr;
	private int enMin;
	private int exHr;
	private int exMin;
	private boolean mem;
	private int duration;
	private int fee;
	private int tempFee;
	private boolean isEarly;
	// Default constructor 
	public Driver()
	{}
	// Constructor
	public Driver(int entryHour, int entryMinute, int exitHour, int exitMinute, boolean member)
	{
		enHr = entryHour;
		enMin = entryMinute;
		exHr = exitHour;
		exMin = exitMinute;
		mem = member;
	}
	// Calculate duration of stay
	public void calcDuration(int enHr, int enMin, int exHr, int exMin)
	{
		duration = ((exHr - enHr) * 60) + (exMin - enMin);
	}
	// Get method for duration
	public int getDuration()
	{
		return duration;
	}
	// Check to see if driver qualifies for early rates
	public void checkEarly(int enHr, int enMin, int exHr, int exMin)
	{
		if (enHr < 10)
		{
			if (enMin == 0)
			{
				isEarly = true;
			}
		}
		else
		{
			isEarly = false;
		}
	}
	// Get method for isEarly
	public boolean getIsEarly()
	{
		return isEarly;
	}
	// Calculate the fee with a bunch of if statements
	public void calcFee(int enHr, int enMin, int exHr, int exMin, boolean mem)
	{
		// If duration is negative, you messed up and deserve to pay the whole fine
		if (duration < 0)
		{
			fee = 15;
		}
		// If duration is less than 5 minutes, you probably couldn't find parking and
		// don't deserve to get fined
		else if (duration < 5)
		{
			fee = 0;
		}
		// Otherwise....
		else
		{
			// Calculate parking price here, maximum charge is $15
			// Rate is $2 for each 30 minute block of time the car is present in the parking deck
			// I.E. any time from 31-60 minutes is $4 ($2 + $2)
			if ((0 < (duration % 30)) && ((duration % 30) < 30))
			{
				fee = ((duration / 30) + 1) * 2;
				tempFee = fee;
			}
			else
			{
				fee = (duration / 30) * 2;
				tempFee = fee;
			}
			// Checks to see if the driver is a member of the school
			if (mem == true)
			{
				// Checks to see if the discount will result in a negative charge and prevents it
				if (tempFee < 3)
				{
					fee = 0;
				}
				// Otherwise off the $3 discount for members of the school
				else
				{
					fee -= 3;
				}
				// Checks if the member is eligible for the early rate
				if (isEarly == true)
				{
					// Checks to see if the senior discounted price is better than early price
					if ((tempFee < fee) & (tempFee <= 10) & (tempFee <= 15))
					{
						fee = tempFee;
					}
					// School members who are early have the opportunity to pay a maximum of $7
					else if (tempFee > 10)
					{
						fee = 7;	
					}
					// Otherwise use the calculated rates
					else if (tempFee < fee)
					{
						fee = tempFee;
					}
					else
					{
						fee = fee;
					}
				}
				// USe calculated rates
				else if (tempFee < fee)
				{
					fee = tempFee;
				}
				else
				{
					fee = fee;
				}
			}
			// Checks if driver is eligible for the early rate
			else if (isEarly == true)
			{
				// If early, driver never pays over $10
				if ((tempFee < fee) & (tempFee <= 10))
				{
					fee = tempFee;
				}
				else if (tempFee <= 10)
				{
					fee = tempFee;
				}
				else
				{
					fee = 10;
				}
			}
			// Otherwise checks to see if fee is over $15
			// If it would be, make it $15 then
			else
			{
				if (fee > 15)
				{
					fee = 15;
				}
			}
		}
	}
	// Get method for fee
	public int getFee()
	{
		return fee;
	}
}