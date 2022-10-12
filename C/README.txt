C READ ME FILE
TO COMPILE: gcc Happy.lc -lm
TO RUN: ./a.out

OUTPUT EXAMPLES:
  a) 10-30
    First Argument: 10
    Second Argument: 30
    19
    28
    23
    13
    10

  b) 200-50 (with swap of course)
    First Argument: 50
    Second Argument: 200
    188
    193
    190
    192
    139
    176
    167
    133
    94
    129

  c)410-430 (Nobody's happy example)
    First Argument: 410
    Second Argument: 430
    NOBODIES HAPPY!






METHODS:
1. Struct Node: creates a struct which contains int data, double normedValues, and Struct Node* next.

2.printList: Print List will print the values as long as n is not null

3.swap: Swap method helps when I sort the values

4.bubbleSort: Bubble sort will sort the values based off of the normed values

5.sumDigitSquare: does happy calculations to determine if a number is a happy number

6.isHappy: checks to see if a number is happy or not

7.breakdown: breaksdown the happy numbers and finds the normed values

8. main: Main method steps
  a) get user input (firstNum and secondNum)
  b)swap the values if second is greater than first
  c)print the arguments
  d)THE FOR LOOP: this loop adds values that are happy numbers and their norms to a linked list. It is also does math calculations for them too.
  e)call bubble sort and printReverse methods