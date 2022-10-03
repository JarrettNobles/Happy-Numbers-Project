#!/usr/bin/perl
main();

#build an array of hashes
@AoH = ( 
  {
    data =>$normedvalues,
    key =>$key,
  },
);
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

  $i=$firstNum;

  #calculate the norms
  #while($i<$secondNum){

  #}

}

#swap sub function to swap the numbers if first number entered bigger than the 2nd
sub swap{
 if($firstNum > $secondNum){
  	($firstNum,$secondNum) = ($secondNum,$firstNum);
  }
}

#sum digit square function
sub sumDigitSquare($n){
  $sq=0;
  while($n>0){
    $digit = $n%10;
    $sq += $digit * $digit;
    $n = $n/10;
  }
  return $sq;

}
#is happy function
sub isHappy($n){
  #data structure (array) to store the numbers during repeated square sum process
  @normedvalues = ($n);

  #keep replacing n with sum of squares of digits until we either reach 1 or we endup in a cycle
  while(true)
  {
    #number is happy if we reach 1
    if($n==1)
    {
      return true;
    }
    #replace n with sum of squares of digits
    #error here "aborted due to compilation error, near $n, not enough arguements" when I call sumDigitSquare($n)
    $n=&{sumDigitSquare}($n);

    #if n is already visited, a cycle is formed, means not happy
    if($n = $s){
      return false;
    }

    #mark n as visited
    @normedvalues=($n);
    
    
  }
  return false;


}

  
