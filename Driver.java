// This is the driver class

import java.util.Scanner;
import java.lang.Math;

public class Driver
{
	private int enHr;
	private int enMin;
	private int exHr;
	private int exMin;
	private boolean mem;
	private int duration;
	private int fee;
	private int tempFee;
	private boolean isEarly;

	public Driver()
	{}

	public Driver(int entryHour, int entryMinute, int exitHour, int exitMinute, boolean member)
	{
		enHr = entryHour;
		enMin = entryMinute;
		exHr = exitHour;
		exMin = exitMinute;
		mem = member;
	}

	public void calcDuration(int enHr, int enMin, int exHr, int exMin)
	{
		duration = ((exHr - enHr) * 60) + (exMin - enMin);
	}

	public int getDuration()
	{
		return duration;
	}

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

	public boolean early()
	{
		return isEarly;
	}

	public void calcFee(int enHr, int enMin, int exHr, int exMin, boolean mem)
	{
		if (duration < 0)
		{
			fee = 15;
		}
		else if (duration < 5)
		{
			fee = 0;
		}
		else
		{
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

			if (mem == true)
			{
				if (tempFee < 3)
				{
					fee = 0;
				}
				else
				{
					fee -= 3;
				}
				if (isEarly == true)
				{
					if ((tempFee < fee) & (tempFee <= 10) & (tempFee <= 15))
					{
						fee = tempFee;
					}
					else if (tempFee > 10)
					{
						fee = 7;	
					}
					else if (tempFee < fee)
					{
						fee = tempFee;
					}
					else
					{
						fee = fee;
					}
				}
				else if (tempFee < fee)
				{
					fee = tempFee;
				}
				else
				{
					fee = fee;
				}
			}
			else if (isEarly == true)
			{
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
			else
			{
				if (fee > 15)
				{
					fee = 15;
				}
			}
		}
	}

	public int getFee()
	{
		return fee;
	}
}