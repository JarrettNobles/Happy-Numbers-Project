import java.util.*;
import java.math.*;
//JARRETT NOBLES
//CSC330


public class Happy {

    public static void main (String[] args)
    {   
        //data structures to store the normed values (array list) and a treemap to sort them by the norms
        ArrayList<Double> normedvalues = new ArrayList<Double>();
        TreeMap<Double, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        //user input section
        Scanner in = new Scanner(System.in);
        int firstNum ,secondNum;
        System.out.print("Enter the first number: ");
        firstNum = in.nextInt();
        System.out.print("Enter the second number: ");
        secondNum = in.nextInt();
        //check if second number is greater than the first and swap the values
        int temp;
        if(secondNum < firstNum)
        {
            temp = firstNum;
            firstNum = secondNum;
            secondNum = temp;

        }
        System.out.println("First Argument: " + firstNum);
        System.out.println("Second Argument: " + secondNum);

        //add normed values to treemap
        for(int i = firstNum; i <= secondNum; i++) {
            if (isHappy(i)) {
                normedvalues.add((double) i);
                breakdown(i,normedvalues);
                double sum = 0;
                for( int a = 0; a < normedvalues.size(); a++)
                {
                    sum = sum + Math.pow(normedvalues.get(a),2);
                }
                sum = Math.sqrt(sum);
                treeMap.put(sum, i);
                normedvalues.clear();

            }
            
        }
        //call print reverse tree method to sort the tree values in descending
        printReverseTreeMap(treeMap);
    }
    public static int sumDigitSquare(int n)
    {
        int sq = 0;
        while (n > 0) {
            int digit = n % 10;
            sq += digit * digit;
            n = n / 10;
        }
        return sq;
    }
    public static boolean isHappy(int n)
    {
        // A set to store numbers during
        // repeated square sum process
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(n);

        // Keep replacing n with sum of squares of digits until we either reach 1 or we end up in a cycle
        while (true)
        {

            // Number is Happy if we reach 1
            if (n == 1)
                return true;

            // Replace n with sum of squares of digits
            n = sumDigitSquare(n);

            // If n is already visited, a cycle is formed, means not Happy
            if ((s.contains(n) && n != (int)s.toArray()[ s.size()-1 ] ))
                return false;

            // Mark n as visited
            s.add(n);
        }
        
    }

    //this method solves for the normed values
    static void breakdown(int n, ArrayList<Double> normedvalues )
    {
        int digit =0;
        int number =0;
        int a = 0;
        while(n> 0)
        {
            digit = n%10;
            n = n/10;

            a =(int)(a + Math.pow(digit,2));

        }
        normedvalues.add((double)a);
        if(a !=1) {
            breakdown(a, normedvalues);
        }
    }

    //this method does the sorting in descending order by using an iterator and a set
    public static void printReverseTreeMap(TreeMap<Double,Integer>treeMap)
    {
        int i =0;
        Set set = treeMap.entrySet();
        Iterator it = set.iterator();

        int a =0;
        while(it.hasNext() && a < 10)
        {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getValue());
            a++;
        }
        if(treeMap.isEmpty())
        {
            System.out.println("NOBODIES HAPPY!");
        }
        
    }
}
