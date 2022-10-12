#!/usr/bin/sbcl --script


 (defun main()
  (princ "Enter the First Argument: ")
  (setq firstNum(read))
  (terpri)
  
  (princ "Enter the Second Argument: ")
  (setq secondNum(read))
  (terpri)
  
  (princ "First Argument: ")
  (write firstNum)
  (terpri)
  (princ "Second Argument: ")
  (write secondNum)
  (terpri)
  
  
  ; (main)
 )
  
  










(defun sqr (n)
  (* n n))

(defun sum-of-sqr-dgts (n)
  (loop for i = n then (floor i 10)
        while (plusp i)
        sum (sqr (mod i 10))))
 
(defun happy-p (n &optional cache)
  (or (= n 1) 
      (unless (find n cache)
        (happy-p (sum-of-sqr-dgts n)
                 (cons n cache)))))
 
(defun happys (&aux (happys 0))
  (loop for i from 1
        while (< happys 8)
        when (happy-p i)
        collect i and do (incf happys)))
        ; test commit comment
 
(print (happys))
(terpri)