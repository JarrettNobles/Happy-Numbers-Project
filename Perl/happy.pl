#!/usr/bin/perl

print "Enter the first argument: \n";
my $firstNum = <STDIN>;
print "Enter the second argument: \n";
my $secondNum = <STDIN>;
print "First Argument: ",$firstNum,"\n";
print "Second Argument: ",$secondNum,"\n";

if($firstNum > $seconNum){
	($firstNum,$secondNum) = ($secondNum,$firstNum);
}

print "First Argument: ",$firstNum,"\n";
print "Second Argument: ",$secondNum,"\n";


