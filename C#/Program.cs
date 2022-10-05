using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
public class HappyNums{
  static public void Main()
  {
    int firstNum;
    int secondNum;
    //List and sorted dictionary to store the happy numbers and sort by normed values (dictionary treeMap)
    List <int> normedvalues = new List<int>();
    SortedDictionary<double, int> treeMap = new SortedDictionary<double, int>();
    //obtain user input
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
    
    //calculate norms for happy numbers
    for(int i = firstNum; i <= secondNum; i++)
    {
   	  if(isHappy(i))
	    {
	      normedvalues.Add(i);
	      breakdown(i,normedvalues);
	      double sum = 0; 
        for(int a = 0; a < normedvalues.Count; a++) 
        {
		      sum = sum + Math.Pow(normedvalues.ElementAt(a),2);
	      }	
	      sum = Math.Sqrt(sum);

        if (!treeMap.ContainsKey(sum))
        {
          treeMap.Add(sum,i);
        }
        normedvalues.Clear();		
	    } 
    }
    //print the dictionary
    printReverseTreeMap(treeMap);
    
    
  }
  
  //method does the calculations for happy numbers
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
  
  //checks if a number is a happy number based on values from sumDigitSquare
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

  //this method breaksdown the happy numbers and calculates the normed values
  static void breakdown(int n, List<int> normedvalues)
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
    normedvalues.Add(a);
    if(a != 1)
    {
      breakdown(a, normedvalues);
    }
  }
  
  //this function prints the dictionary in descending order, also it will print NOBODIES HAPPY if dictionary size is 0
  static public void printReverseTreeMap(SortedDictionary <double, int> treeMap)
  {
    int a = 0;
    for (int z = treeMap.Count-1; z >= 0 && a < 10; z--)
    {
      var item = treeMap.ElementAt(z);
      var itemValue = item.Value;
      Console.WriteLine(itemValue);
      a++;
    }
    if(treeMap.Count==0)
    {
      Console.WriteLine("NOBODIES HAPPY!");
    }
  }
  }

