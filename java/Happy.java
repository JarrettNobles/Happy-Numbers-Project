import java.util.*;
import java.util.Scanner;
import java.util.TreeMap;
import java.lang.Math;
import java.lang.*;
import java.util.HashSet;
//begin class
public class Happy{
  //global variables
 public static  int firstNum,secondNum, oNum ,norm;
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
        for(Long i : treeMap.descendingKeySet()){
            NavigableSet newTree = treeMap.descendingKeySet();
            Iterator itr1 = newTree.iterator();
            System.out.println(itr1.next());

            //System.out.println(i);


        }
    }
  //happy number calculations
    //TURN THIS METHOD INTO AN ARRAY
  public static void happyCheck(TreeMap<Long, Integer> treeMap) {
      int sum = 0;
      int r, i, n;
      int oNum;
      System.out.println("The happy numbers are: ");
      int sum2 = 0;
      for (i = firstNum; i <= secondNum; i++) {
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
              System.out.println(oNum); //prints original number
              cycle.add((long) i); //adds o num to hash
              //System.out.println(cycle); //prints the full hash
              cycle.toArray();
              //for(Long norm: cycle){
              //sum2 += Math.sqrt(Math.pow(norm,2));
              //norm = Long.valueOf((int) Math.pow(norm,2));
              //System.out.println(sum2);
              //int norm = (int) Math.sqrt(sum2);

              //}
              //System.out.println(sum2);
          }
      }

      for (Long value : cycle) {
          sum2 += Math.sqrt(Math.pow(value, 2));
          //norm = Long.valueOf((int) Math.pow(norm,2));
          //System.out.println(sum2);
          //int norm = (int) Math.sqrt(sum2);

      }
      System.out.println(sum2);


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
