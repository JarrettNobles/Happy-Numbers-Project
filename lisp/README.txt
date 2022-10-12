LISP README FILE

TO COMPILE: chmod u+x happy.lisp
TO RUN: ./happy.lisp

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
MAIN: get user input

THESE METHODS USED FROM ROSETTA CODE https://rosettacode.org/wiki/Happy_numbers#Common_Lisp
(defun sqr (n),(defun sum-of-sqr-dgts (n),(defun happy-p (n &optional cache),(defun happys (&aux (happys 0))