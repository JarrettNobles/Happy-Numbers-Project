GO READ-ME FILE

TO COMPILE AND RUN: go run happy.go

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
  MAIN:
    1.Declare data structures: map (type float64 and int) named treeMap. In this program normedvalues is an array of the float64 data type, but it is a global array.
    2.Obtain user input and swap the values if necessary.
    3.adding normedvalues to treemap and it does the math for them (forloop), starts by checking if a number isHappy then do the math for it. It adds it to the treeMap then clears normedValues.
    4.Sorting: reverse sort the treemap and print "NOBODIES HAPPY!" if necessary
    
    sumDigitSquare:
    1. sumDigitSquare does math to calculate if a number is a happy number.
  
  isHappy:
    1. Uses a hash set and checks if the values are happy-numbers based off of sumDigitSquare math calculations.
  
  breakdown:
    1. Breakdown method breaks down the happy numbers and calculates the normed values for them.
    
  reverseMap:
    1. Iterates through the map for sorting, and adjusts it. 