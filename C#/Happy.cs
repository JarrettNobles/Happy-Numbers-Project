using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
public class Happy{
  static public void Main()
  {
    int firstNum;
    int secondNum;
    ArrayList normedvalues = new ArrayList();
    //SortedList<double,int> treeMap = new SortedList<double,int>();
    SortedList treeMap = new SortedList();
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
    
    //for(int i = firstNum; i <= secondNum; i++)
    //{
      
    //}
    
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

  static void breakdown(int n,ArrayList normedvalues)
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
  
  static public void printReverseTreeMap(


}