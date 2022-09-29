#!/usr/bin/perl
main();
sub main{
  
  #user input section
  print "Enter the first argument: \n";
    $firstNum = <>;
    chomp($firstNum);
  print "Enter the second argument: \n";
    $secondNum = <>;
    chomp($secondNum);
  swap();
  print "First Argument: ",$firstNum,"\n";
  print "Second Argument: ",$secondNum,"\n";
  
  #for loop to calculate norms
  #for($i = $firstNum; $i <= $secondNum; $i++){
    
  #}

}

#swap sub function to swap the numbers if first number entered bigger than the 2nd
sub swap{
 if($firstNum > $secondNum){
  	($firstNum,$secondNum) = ($secondNum,$firstNum);
  }
}
#sub int sumDigitSquare($n){
sub sumDigitSquare($n){
  $sq=0;
  while($n>0){
    $digit = $n%10;
    $sq += $digit * $digit;
    $n = $n/10;
  }
  return $sq;

}

  
