


#obtain inputs
firstNum = int (input("Enter the first Argument "))
secondNum = int(input("Enter the second argument "))


#swap function
if firstNum >  secondNum:
	temp = firstNum
	firstNum = secondNum
	secondNum = temp
	

print("First Argument: ", firstNum)
print("Second Argument: ", secondNum)

while sum!=1:
  for i in range (firstNum, secondNum):
	  sum = 0
	  num = i
	  while sum!=1 and sum!=4:
		  sum=0
		  while num>0:
		  	r = num % 10
		  	sum = sum + ( r * r)
		  	num = num / 10
  	num = sum

	#print statement
	if sum == 1:
		print(i)

