using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
public class Happy{
  static public void Main()
  {
    int firstNum;
    int secondNum;
    SortedList<double, int>  normedvalues = new SortedList<double, int>();
    Dictionary <double, int> treeMap = new Dictionary <double, int>();
    Console.WriteLine("Enter the first argument: ");
    String str1 = Console.ReadLine();
    firstNum = Convert.ToInt32(str1);
    Console.WriteLine("Enter the second argument: ");
    String str2 = Console.ReadLine();
    secondNum = Convert.ToInt32(str2);
    
    //check to see if second number is greater than the first and swap the values
    if(secondNum < firstNum)
    {
      int temp = firstNum;
      firstNum = secondNum;
      secondNum = temp;
    }
    Console.WriteLine("First Argument: "+firstNum);
    Console.WriteLine("Second Argument: "+secondNum);
    
    for(int i = firstNum; i <= secondNum; i++)
    {
   	  if(isHappy(i))
	    {
	    normedvalues.Add(i);
	    breakdown(i,normedvalues);
	    double sum = 0;
	    for(int a = 0; a < normedvalues.Count(); a++)
	    {
		    sum = sum + Math.Pow(normedvalues.Count(a),2);
	    }	
	    sum = Math.Sqrt(sum);
 	    treeMap.Add(sum,i);
	    normedvalues.Clear();		
	    } 
    }
    
  }
  
  static public int sumDigitSquare(int n)
  {
    int sq = 0;
    while(n > 0)
    {
      int digit = n % 10;
      sq+= digit * digit;
      n = n/10;
    }
    return sq;
  
  }
  
  static public bool isHappy(int n)
  {
    HashSet<int> s = new HashSet<int>();
    s.Add(n);
    
    while(true)
    {
      if(n == 1)
      
        return true;
      
      n = sumDigitSquare(n);
      
      if((s.Contains(n) && n!= (int)s.ToArray()[s.Count()-1]))
        return false;
        
        
      s.Add(n);
      
      
    }
  
  }

  static void breakdown(int n, SortedList<double,int> normedvalues)
  {
    int digit = 0;
    int number = 0;
    int a = 0;
    while( n > 0 )
    {
      digit = n % 10;
      n = n/10;
      a = (int)(a + Math.Pow(digit,2));
    }
    
    normedvalues.Add((double)a);
    if(a != 1)
    {
      breakdown(a, normedvalues);
    }
  }
  
  static public void printReverseTreeMap(Dictionary <double, int> treeMap)
  {
    int i = 0;
    //Set set = treeMap.
    //HashSet <int> set = new HashSet <int> 
    int a = 0;
    foreach(var x in treeMap.Reverse())
    {
	Console.WriteLine(x);	

    }    
  }
}
