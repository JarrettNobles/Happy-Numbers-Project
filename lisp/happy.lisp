#!/usr/bin/sbcl --script
(write-line "Hello, World!")
(defun main())
(
    ; user input 
    (princ "Enter the First Argument: ")
    (setq firstNum(read))
    (princ "Enter the Second Argument: ")
    (setq secondNum(read))

    ; switch statement
    (let ((value value)) 
        (cond ((eql value '"XY") (print "XY")) 
         ((eql value '"AB")))
    
    (princ "First Argument: ")
    (write firstNum))
    (princ "Second Argument: ")
    (write secondNum))

)