import java.util.*;
import java.util.Scanner;
import java.util.TreeMap;
import java.lang.Math;
import java.lang.*;
import java.util.HashSet;
//begin class
public class Happy{
  //global variables
 public static  int firstNum;
    public static int secondNum;
    public static int oNum;
    public static double norm;
  public  static TreeMap <Long, Integer> treeMap = new TreeMap<>();
  //public static HashMap <Long, Integer> cycle = new HashMap<Long, Integer>();
  public static HashSet<Long> cycle = new HashSet<Long>();
  //takes user input, it also prints the first and second argument the user enters and it will flip them if first is bigger than second
  public  static void isHappy()
  {
    Scanner in = new Scanner(System.in);
   //System.out.println("Enter the first argument:");
    //firstNum = in.nextInt();
    firstNum = 10;
    //System.out.println("Enter the second argument");
    //secondNum = in.nextInt();
    secondNum = 30;
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
        for(Long oNum : treeMap.descendingKeySet()){
            NavigableSet newTree = treeMap.descendingKeySet();
            System.out.println("test");
            Iterator itr1 = newTree.iterator();
            System.out.println(itr1.next());




        }
    }
  //happy number calculations
    //TURN THIS METHOD INTO AN ARRAY
  public static void happyCheck(TreeMap<Long, Integer> treeMap) {

      int finalAnswer;
      int sum = 0;
      int r, i, n;
      int oNum;
      System.out.println("The happy numbers are: ");
      int sum2 = 0;
      for (i = firstNum; i <= secondNum; i++) {
         int  square = 0;
          sum2 = 0;
          oNum = i;
          n = i;
          sum = 0;
          while (sum != 1 && sum != 4) {
              sum = 0;
              while (n > 0) {
                  r = n % 10;
                  sum += (r * r);
                  n = n / 10;
              }
              n = sum;
          }
          if (sum == 1) {
              cycle.toArray();
              //System.out.println(oNum);//prints original number
              //square i
              square += i * i;
              //adds squared values to hash
              cycle.add((long) square);
              //System.out.println(cycle);
              //take the sum of cycle
              norm+=square;
                //take square root of the sum
              finalAnswer = (int) Math.sqrt(norm);
              //System.out.println(finalAnswer);
              System.out.print(norm + " ");
              System.out.println(oNum);
              treeMap.put((long)oNum, square);

          }
      }

      //for loop to possibly use to take  the sum of the hash?
      for (Long value : cycle) {
          //System.out.print(value);
          //sum function
          //norm += value;
          //System.out.println(norm);
          //finalAnswer = (int) Math.sqrt(norm);
          //System.out.println(finalAnswer);



      }

  }

  //main method
  public static void main(String[] args)
  {
    Happy isHappy = new Happy();
    isHappy.isHappy();
    //isHappy.happyCheck();
    isHappy.happyCheck(treeMap);
  }
}
