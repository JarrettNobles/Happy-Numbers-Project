#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#define CACHE 256
double *normedvalues;
size_t normedSize = 1;

struct pair
{
    double key;
    int value;

};
struct pair *valuesVec;
size_t valuesVecSize = 0;


int sumDigitSquare(int n)
{
    int sq = 0;
    while( n > 0){
        int digit = n % 10;
        sq += digit * digit;
        n = n/10;
    }
    return sq;
}

bool isHappy(int n)
{
    // Keep replacing n with sum of squares of digits until
    // we either reach 1 or we end up in a cycle
    while (1) {
        // Number is Happy if we reach 1
        if (n == 1)
            return true;
        // Replace n with sum of squares of digits
        n = sumDigitSquare(n);
        // Number is not Happy if we reach 4
        if (n == 4)
            return false;
    }
    return false;
}

void breakdown(int n, double *normedvalues)
{
    int digit = 0;
    int number = 0;
    int a = 0;

    while(n>0)
    {
        digit = n%10;
        n = n/10;

        a = a + pow(digit,2);

    }
    int size = sizeof(normedvalues)/sizeof(normedvalues[0]);
    normedSize +=1;
    normedvalues =realloc(normedvalues,normedSize * sizeof(double));

    normedvalues[(int)normedSize] = a;
    printf("%f\n",normedvalues[(int)normedSize]);
    if(a!= 1)
    {
        breakdown(a,normedvalues);
    }
    printf("normed size is:  ");
    int size1= (int)normedSize;
    printf("Size is:\n");
    printf("%d\n",size1);

}

int main()
{
    //declare data types to store here
    normedvalues = calloc(1,sizeof(double));
    printf("1\n");


    for(int i =19; i <=20; i++)
    {
        printf("2\n");
        if(isHappy(i)){
            normedvalues[i] = i;
            breakdown(i, (double *) (double **) normedvalues);
            double sum =0;
            int size = sizeof(*normedvalues)/sizeof(normedvalues[0]);
            printf("value is:");
            double value = normedvalues[3];
            printf("%f\n", value);

            for(int a =0; i < normedSize; a++)
            {   printf("3\n");
                sum = sum + pow(normedvalues[a],2);
            }
            sum = sqrt(sum);
            printf("4\n");
            struct pair pairval = {sum,i};
            //int ValuesSize = sizeof(valuesVec)/sizeof(valuesVec[0]);
            valuesVec[valuesVecSize] =pairval;
            printf("5\n");
            memset(normedvalues,0, sizeof *normedvalues);

        }
    }
    printf("6\n");
    double value = valuesVec[0].key;
    printf("%d", value);
    //for(int i =0; i<10; i++)
    //{
    //    double value = (valuesVec[i].key);
   //     printf("%d", value);
   // }



    //user input section
    /* int firstNum;
     int secondNum;
     printf("Enter the first Argument: ");
     scanf("%d", &firstNum);
     printf("Enter the second Argument: ");
     scanf("%d", & secondNum);
     //swap statement
     if(secondNum < firstNum)
     {
         int temp = firstNum;
         firstNum = secondNum;
         secondNum = temp;
     }
     printf("First Argument: %d", firstNum);
     printf("\nSecond Argument: %d",secondNum);
     printf("\n");
     */


    //for loop to do math for happy nums here to calculate norms

    free(normedvalues);


}

