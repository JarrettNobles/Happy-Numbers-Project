import java.util.*;
import java.math.*;



public class HappyNums2 {

    public static void main (String[] args)
    {   ArrayList<Double> normedvalues = new ArrayList<Double>();
        //vector<double> normedvalues;
        //TreeMap<Integer, Double> treeMap = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Double, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        //map<int, float> values;
        //vector<pair<int, double>> valuesVec;
        //ArrayList<TestPair> valuesVec = new ArrayList<>();
        //int n = 19;
        for(int i =50; i <= 200; i++) {
            if (isHappy(i)) {
                normedvalues.add((double) i);
                breakdown(i,normedvalues);
                double sum =0;
                for( int a =0; a <normedvalues.size(); a++)
                {
                    sum = sum + Math.pow(normedvalues.get(a),2);
                }
                sum = Math.sqrt(sum);
                treeMap.put(sum, i);
                normedvalues.clear();

            }

        }

        printReverseTreeMap(treeMap);

        //sort(valuesVec.begin(), valuesVec.end(), sortbysecdesc);


        /*for (int i=0; i<treeMap.size() && i < 10; i++)
        {
            // "first" and "second" are used to access
            // 1st and 2nd element of pair respectively
            cout << valuesVec[i].first << " "
                    << valuesVec[i].second << endl;
        }

         */
        for(Map.Entry<Double, Integer> entry :treeMap.entrySet())
        {
            System.out.println("Key: " + entry.getKey() + "Value: " + entry.getValue());
        }


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

        // Keep replacing n with sum of
        // squares of digits until we either
        // reach 1 or we endup in a cycle
        while (true)
        {

            // Number is Happy if we reach 1
            if (n == 1)
                return true;

            // Replace n with sum of squares
            // of digits
            n = sumDigitSquare(n);

            // If n is already visited, a cycle
            // is formed, means not Happy

            if ((s.contains(n) && n != (int)s.toArray()[ s.size()-1 ] ))
                return false;

            // Mark n as visited
            s.add(n);
        }

    }
    public static double norm1(int n )
    {
        int r=0;
        double total=0;
        while(n!=0)
        {
            r=n%10;
            n=n/10;

            total = total+norm(r);
        }

        return total;
    }
    /*public boolean sortbysecdesc(const pair<int,double> &a,
                   const pair<int,double> &b)
    {
        return a.second>b.second;
    }
    */

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


    public static double norm(int n)
    {
        int d =0;
        int s =0;
        while(n>0 )
        {
            d = n%10;
            s = s+d*d;
            n = n/10;
        }
        return Math.sqrt(s);
    }

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


            /*for(Double key : treeMap.keySet()) {
                if(i > 10)
                {
                    break;
                }
                System.out.println(treeMap.get(key));
                i++;
            }

             */

    }




}
