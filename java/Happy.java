import java.util.*;
import java.util.Scanner;
import java.util.HashSet;
public class Happy
{
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Happy Numbers");
		//take user input for the first number
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the first number value");
		long firstNum = in.nextLong();
		//take user input for the 2nd number
		System.out.println("Please enter the second number value");
		//Scanner in2 = new Scanner(System.in);
		int secondNum = in.nextInt();
		System.out.println("First Argument: " + firstNum);
		System.out.println("Second Argument:  " + secondNum);	
		for(long firstNum = 1, secondNum = 0; seconNum <8; firstNum++)
		{
			if(happy(firstNum))
			{
				System.out.println(firstNum);
				count++;
			}

		}
	}

	public static boolean happy(long number)
	{
		long firstNum = 0;
		int secondNum = 0;
		HashSet <Long> cycle = new HashSet<Long>();
		while(number !=1 && cycle.add(number))
		{
			firstNum = 0;
			while(number > 0)
			{
				secondNum = (int)(number % 10);
				firstNum += secondNum * secondNum;
				number /= 10;

			}
			
			number = firstNum;
		}
		return number == 1;
	}
	



}
