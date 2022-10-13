#!/usr/bin/perl
use List::Util qw(sum);
#JARRETT NOBLES
#CSC330
#data structure to store the happy numbers and normed values
%values = ();

#checks if a number is a happy number
sub is_happy {
    my ($n) = @_;
    my %seen;
    while (1) {
        $n = sum map { $_ ** 2 } split //, $n;
        return 1 if $n == 1;
        return 0 if $seen{$n}++;
    }
}
#breaksdown the happy numbers to find the normed values
sub breakdown {
    my ($z) = $_[0];
    my ($var2) = $_[1]; #sum
    my $digit = 0;
    my $number = 0;
    my $l = 0; #a
    while ($z > 0 ) {
      $digit = ($z % 10);
      $z = int($z/10);
      $l = ($l + ($digit**2));
    }

    if($l != 1) {
      return ($var2 + $l**2) + breakdown($l, $var2);
    }
    else {
      return $var2;
    }
    
  }
  
#user input section

my $input;
my $input2;

print "First Argument: ";
$input = <STDIN>;
print "Second Argument: ";
$input2 = <STDIN>;

#swap statement if second number is less than the first
if($input2 < $input){
  my $temp = $input2;
  $input2 = $input;
  $input = $temp;
  
}


#call breakdown function and do calculations for norms and if a number is a happy number
while($input <= $input2)
{
  if(is_happy($input) == 1)
  {
    my $var5;
    $var5 = sqrt($input**2+breakdown($input, 0)+1);
    $values{$input} = $var5;
    
  }
  ++$input;
}
$size = keys %values;

#if size is 0, then nobody is happy
if($size == 0){
print "NOBODYS HAPPY!\n";
}

#sorts the happy numbers based on normed values
my $count = 0;
foreach my $name ( reverse sort { $values{$a} <=> $values{$b} } keys %values) {
    if($count < 10){
      print $name . "\n"; 
      $count = $count +1;
    }
}
