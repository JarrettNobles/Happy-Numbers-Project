import java.util.*;
import java.util.Scanner;
import java.util.TreeMap;

//begin class
public class Happy{

  //global variables
 public static  int firstNum,secondNum;

  //hash map originally
  public  static HashMap<Long, Integer> cycle = new HashMap<>();
 //public  static HashSet<Long> cycle = new HashSet<>();
  public  static TreeMap <Long, Integer> treeMap = new TreeMap<>(cycle);
  //takes user input, it also prints the first and second argument the user enters and it will flip them if first is bigger than second
  public  static void isHappy()
  {
  //first step is take user input
    Scanner in = new Scanner(System.in);
   //System.out.println("Enter the first argument:");
    //firstNum = in.nextInt();
    firstNum = 10;
    //System.out.println("Enter the second argument");
    //secondNum = in.nextInt();
    secondNum = 30;
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
  //print the reverse tree order
    public static void printReverseTreeMap(TreeMap<Long,Integer> treeMap)
    {
        for(Long i : treeMap.descendingKeySet()){
            //NavigableSet newTree = treeMap.descendingKeySet();
            //Iterator itr1 = newTree.iterator();
            //System.out.println(itr1.next());//prints 10 right now, either stores 1 from sum or num?
            //System.out.println(itr1.next());
            //Set <Long> i = treeMap.descendingKeySet();
            System.out.println(i);


        }
    }
  //happy number calculations
  public static void happyCheck(TreeMap<Long, Integer> treeMap)
  {
    int sum = 0; 
    int s, i, num;
    System.out.println("The happy numbers are: ");
    for(i = firstNum; i<= secondNum; i++)
    {
      num = i;
      sum = 0;
      while (sum != 1 && sum != 4)
      {
        sum = 0;
        while (num > 0 )
        {
          s = num % 10;
          sum += (s * s);
          num = num / 10;
        }
       num = sum;
      }

      //prints to the tree map
      if(sum == 1)
      {
        cycle.put((long)i,sum);
        //System.out.println(cycle);
      }
    }
    treeMap.putAll(cycle);
    printReverseTreeMap(treeMap);
  }

  //main method
  public static void main(String[] args)
  {
    Happy isHappy = new Happy();
    isHappy.isHappy();
    isHappy.happyCheck(treeMap);
  }
}
