# happyproj
Project 1 for CSC330 Fall 2022
DUE ON 10/12/2022

This project calculates happy numbers for a range of numbers. A number is called happy if it leads to 1 after a sequence of steps wherein each step number is replaced by the sum of squares of its digit that is if we start with Happy Number and keep replacing it with digits square sum, we reach 1.  
EXAMPLE HAPPY NUMBER:
Input: n = 19
Output: True
19 is Happy Number,
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
As we reached to 1, 19 is a Happy Number.
(used this example from https://www.geeksforgeeks.org/happy-number/ )

COMPILE AND RUN INSTRUCTIONS FOR EACH LANGUAGE(THEY ARE ALSO CONTAINED IN EACH LANGUAGES SEPERATE READ-ME FILE)

C-LANGUAGE:
  TO COMPILE: gcc Happy.lc -lm
  TO RUN: ./a.out
  
C# LANGUAGE:
  TO COMPILE: mcs Program.cs
  TO RUN: mono Program.exe
  
FORTRAN LANGUAGE:
  TO COMPILE: gfortran main.f95
  TO RUN: ./a.out
  
GO LANGUAGE:
  TO COMPILE AND RUN: go run happy.go
  
JAVA LANGUAGE:
  TO COMPILE: javac Happy.java
  TO RUN: java Happy
  
LISP LANGUAGE:
  TO COMPILE: chmod u+x happy.lisp
  TO RUN: ./happy.lisp
  
PERL LANGUAGE:
  TO COMPILE:chmod u+x main.pl
  TO RUN: ./main.pl
  
PYTHON LANGUAGE:
  TO COMPILE AND RUN: python3 HappyNums.py
  
OUTPUT EXAMPLES:
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
    
WORKS CITED FOR THIS README FILE
https://www.geeksforgeeks.org/happy-number/    
“Happy Number.” GeeksforGeeks, GeeksforGeeks, 10 Oct. 2022, https://www.geeksforgeeks.org/happy-number/. 