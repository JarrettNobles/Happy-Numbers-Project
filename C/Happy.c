//Jarrett Nobles
//CSC330
#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
double sum;
int count =0;
struct Node* previous = NULL;
struct Node* curr = NULL;
struct Node* head = NULL;
// A linked list node
struct Node {
    int data;
    double normedvalues;
    struct Node* next;
    //struct Node* back;
};

// Prints the linked list in reverse order
void printReverse(struct Node* head)
{
    // Base case
    if (head == NULL)
        return;

    // print the list after head node
    printReverse(head->next);

    // After everything else is printed, print head
    printf("%d  ", head->data);
    printf("\n");
}

//printlist function
void printList(struct Node* n){
    struct Node* last;
    while (n != NULL) {

        printf(" %d ", n->data);
        printf(" %f ", n->normedvalues);

        n = n->next;

    }

}

//swap to help sort
void swap(struct Node *a, struct Node *b)
{
    int temp = a->normedvalues;
    int temp2 = a ->data;
    a->normedvalues = b->normedvalues;
    a->data = b->data;
    b->normedvalues = temp;
    b->data = temp2;
}

//bubble sort to sort values
void bubbleSort(struct Node *start)
{
    int swapped, i;
    struct Node *ptr1;
    struct Node *lptr = NULL;

    /* Checking for empty list */
    if (start == NULL)
        return;

    do
    {
        swapped = 0;
        ptr1 = start;

        while (ptr1->next != lptr)
        {
            if (ptr1->normedvalues > ptr1->next->normedvalues)
            {
                swap(ptr1, ptr1->next);
                swapped = 1;
            }
            ptr1 = ptr1->next;
        }
        lptr = ptr1;
    }
    while (swapped);
}

//calculations
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

//checks to see if a number is happy
bool isHappy(int n) {
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

//breakdown breaks down the happy numbers and calculations
double breakdown(int n,double sum1){
    int digit =0;
    int number =0;
    int a = 0;
    while(n> 0)
    {
        digit = n%10;
        n = n/10;

        a = a + pow(digit,2);

    }
    //normedValues.emplace_back(a);

    if(a !=1) {
     //   breakdown(a, normedValues);
        return sum1 + pow(a,2)+ breakdown(a,sum1);
        printf("%f",sum);
        printf("\n");
    }
    else{
        //printf("%f",sum1);
        //printf("\n");
        return sum1;
    }

}

//main method
int main(){
    //https://www.geeksforgeeks.org/what-is-linked-list/ used code from this to sort and build linked list

    //user input section
    int firstNum;
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

    //calculate the norms and insert them into the linked list
  
       for(int i =firstNum; i <= secondNum; i++)
       {
           if(isHappy(i))
           {
               struct Node* newNode = NULL;
               newNode = (struct Node*)malloc(sizeof(struct Node));
               newNode ->data = i;
               double normedValue = sqrt(pow(i,2)+breakdown(i,0)+1);
               //printf("%f",normedValue);
               newNode -> normedvalues = normedValue;

               if(count == 0 || head == NULL) //first value
               {
                    head= newNode;
                    curr = newNode;
               }
               else if(count !=0 && head!= NULL  ){

                       curr->next = newNode;
                       curr = newNode;
               }
               
                normedValue = 0;
           }

           count++;

       }
    bubbleSort(head);
    printReverse(head);


        return 0;

}


