#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#define CACHE 256
int main()
{
  //declare data types to store here
  
  
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
  
  //for loop to do math for happy nums here to calculate norms
  
  
  
}

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
  //declare empty array and add int n to array
  int s [] = {};
  s[n];

  while(true)
  {
    if (n == 1)
    {
      return true;
    }
    
    n = sumDigitSquare(n);
  }
}

  