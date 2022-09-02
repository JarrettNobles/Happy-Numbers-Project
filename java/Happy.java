import java.util.*;
import java.util.Scanner;
import java.util.TreeMap;
//begin class
public class Happy{

  //global variables
  int firstNum,secondNum;
public static  TreeMap <Double, Double> treeMap = new TreeMap<>();
  //takes user input, it also prints the first and second argument the user enters and it will flip them if first is bigger than second
  public  void isHappy()
  {
  //first step is take user input
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the first argument:");
    firstNum = in.nextInt();
    System.out.println("Enter the second argument");
    secondNum = in.nextInt();
    ///this is where it will flip the values if the first is bigger than the second
    int temp;
    if(secondNum < firstNum)
		{
			temp = firstNum;
			firstNum = secondNum;
			secondNum = temp;
		}
   //print the arguments
    System.out.println("First Argument:" + firstNum);
    System.out.println("Second Argument:" + secondNum);

  }
  
  //happy number calculations
  public void happyCheck(TreeMap<Double, Double> map)
  {
   // TreeMap <Double, Integer> treeMap = new TreeMap();
    double sum = 0; 
    double s, i, num;
    System.out.println("The happy numbers are: ");
    for(i = firstNum; i<= secondNum; i++)
    {
      num = i;
      sum = 0;
      //System.out.println("test1"); 
      while (sum != 1 && sum != 4)
      {
	//System.out.println("test2");
        sum = 0;
        while (num > 0 )
        {
	  //System.out.println("test3");
          s = num % 10;
          sum += (s * s);
          num = num / 10;
        }
        num = sum;
	//System.out.println("test4");
      }
      
      if(num == 1)
      {
	  System.out.println(i);
   	  map.put(sum, i);
          System.out.println(treeMap);
      }
      
         
    }
   
  }
  
  //main method
  public static void main(String[] args)
  {
    Happy isHappy = new Happy();
    isHappy.isHappy();
    isHappy.happyCheck(treeMap);
  }

 
  
}
