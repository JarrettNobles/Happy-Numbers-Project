package main

import "fmt"
import "math"
//import "sort"




func sumDigitSquare(n int) int {
	var square int = 0
	var digit int =0

	for (n > 0){
		digit = n % 10
		square = square + (digit* digit)
		n = n/10
	}
	return square
}

func isHappy(n int) bool {

	s := map[int] struct{}{}
	s[n] = struct{}{}



	for(true){
		if (n==1){
			return true
		}

		n = sumDigitSquare(n)

		
		if val, ok := s[n]; ok {
			_ = val
			return false
		}

		s[n] = struct{}{}

	}

	return false

//	return false

}

func breakdown(n int , normedValues [] float64){
	var a float64 = 0
	var digit int =0
	
	for n >0{
		digit = n%10
		n = int(n/10)

		var x float64 = float64(digit)


		a = a+ math.Pow(x, 2)
		
		normedValues = append(normedValues,a )

	}
	var b int = int(a)

	if(b!=1){
		breakdown(b,normedValues)
	}

}





func main(){

	//data structures to store norm values go here
	//treeMap := make(map[float64]int)
	//var normedValues [] float64
	fmt.Println("Enter the first argument: ")
	var firstNum int
	fmt.Scanln(&firstNum)
	fmt.Println("Enter the second argument: ")
	var secondNum int 
	fmt.Scanln(&secondNum)
	//calls the swap if statement if second number (200) is greater than first number (50)
	if firstNum > secondNum{
		firstNum = firstNum-secondNum
		secondNum = firstNum+secondNum
		firstNum = secondNum-firstNum
	}
	fmt.Println("First Argument: ",firstNum)
	fmt.Println("Second Argument: ",secondNum)

	//for loop for norms
	//for(int i = firstNum; i < secondNum; i++){
		//if(isHappy(i)){
			
		//}
	//}
	
}


