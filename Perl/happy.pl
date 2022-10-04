#!/usr/bin/perl
main();

#hash for storing
my %hash = {my $key,my $value};
#array 
my @normedvalues;
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
  print"test \n";

  my $i=$firstNum;
  #calculate the norms
  $mySize = keys(@normedvalues);
  print"1 \n";
  for($i=$firstNum; $i<=$secondNum; $i++){
    print @normedvalues;
    print"2 \n";
    #not printing here
    #program is stuck here right now, wont go further than this  
    if(isHappy($i)){
      print"3 \n";
      @normedvalues[$i];
      print @normedvalues;
      breakdown($i,@normedvalues);
      $sum = 0;
      print"4 \n";
      for($a = 0;$a < $mySize;$a++){
        $sum = $sum + @normedvalues[$a]**2;
        print"5 \n";
      }
      $sum=sqrt($sum);
      print"6 \n";
      #add sum and i to hash
      %hash = ($sum,$i);
      print "Hash: ",$hash,"\n";
      #clear the hash
      undef @normedvalues;
      print"7 \n";

    }
    print "8 \n";
  }
  print "Hash: ",$hash,"\n";
  print @normedvalues, "\n";
  print "9 \n";
  printReverse();
}

#swap sub function to swap the numbers if first number entered bigger than the 2nd
sub swap{
 if($firstNum > $secondNum){
  	($firstNum,$secondNum) = ($secondNum,$firstNum);
  }
}

#sum digit square function
sub sumDigitSquare($n){
  my $sq=0;
  while($n>0){
    my $digit = $n%10;
    my $sq += $digit * $digit;
    my $n = $n/10;
  }
  return $sq;

}
#is happy function
sub isHappy($n){
  #data structure (array) to store the numbers during repeated square sum process
  my @s;
  @s[$n];

  #keep replacing n with sum of squares of digits until we either reach 1 or we endup in a cycle
  while(true)
  {
    #number is happy if we reach 1
    if($n==1)
    {
      return true;
    }
    #replace n with sum of squares of digits
    
    my $n=&{sumDigitSquare}($n);

    #if n is already visited, a cycle is formed, means not happy
    if($n = @s){
      return false;
    }

    #mark n as visited
    #@s[$n];
   
    my %seen;

    foreach my $string (@s) {

      next unless $seen{$n}++;
      print "'$n' is duplicated.\n";
    }
    #print "test2 \n";
    
  }
  print "test3";
  return false;
  
}

sub breakdown($n, @normedValues){
  my $a = 0;
  my $number = 0;
  my $digit = 0;
  while($n>0){
    my $digit = int($n%10);
    my $n=int($n/10);
    my $a=$a+$digit**2;
  }
  $normedvalues=($a);
  if($a != 1){
    breakdown($a,$normedvalues);
  }

}

sub printReverse(%hash){
  print @normedvalues;
  print %hash;
}

