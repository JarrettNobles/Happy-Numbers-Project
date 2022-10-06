import math
from collections import OrderedDict

# main function
def HappyNums():  

    #declare data structures to store the normed values	and a dictionary named treemap to sort and store 
    normedValues = list()
    treeMap = dict()
    #take user input
    print("Enter the first argument: ")
    firstNum = int(input())
    print("Enter the second argument: ")
    secondNum = int(input())
    #swap statement
    if secondNum < firstNum:
        temp = firstNum
        firstNum = secondNum
        secondNum = temp

    print("First Argument: " + str(firstNum))
    print("Second Argument: " + str(secondNum))

    i = firstNum
    #add happy numbers to dictionary and sort them
    while i <= secondNum:
        if isHappy(i):
            normedValues.append(i)
            breakdown(i, normedValues)
            sum1 = 0
            a = 0
            while a < len(normedValues):
                sum1 = sum1 + pow(normedValues[a], 2)
                a += 1
            sum1 = math.sqrt(sum1)
            treeMap.update({sum1: i})
            normedValues.clear()
        i += 1

    sortDict = OrderedDict(sorted(treeMap.items()))
    first_ten = OrderedDict(reversed(list(sortDict.items())))
    finalvals = list(first_ten.values())[:10]

    for x in finalvals:
        print(x)





#does calculations for happy numbers
def sumDigitSquare(n):
    sq = 0
    n = int(n)
    while n > 0:
        digit = int(n % 10)
        sq += digit * digit
        n = int(n / 10)

    return sq

#figures out if a number is a happy number based off of sumDigitSquare
def isHappy(n):
    # A set to store numbers during repeated square sum process
    
    s = set()
    s.add(n)

    # Keep replacing n with sum of squares of digits until we either reach 1 or we endup in a cycle
    while True:

        # Number is Happy if we reach 1
        if n == 1:
            return True

        # Replace n with sum of squares of digits
        n = sumDigitSquare(n)

        # If n is already visited, a cycle is formed, means not happy
        if n in s:
            return False

        # Mark n as visited
        s.add(n)

    return False




#breaks down the normed values 
def breakdown(n, normedValues):
    a = 0
    n = int(n)
    while n > 0:
        digit = int(n % 10)
        n = int(n / 10)
        a = a + pow(digit, 2)

    normedValues.append(a)
    if a != 1:
        breakdown(a, normedValues)


if __name__ == '__main__':
    HappyNums()
