package main

import "fmt"
import "math"
import "sort"

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
//checks to see if the number is a happy number
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

//print reverse map function
func printReverseTreeMap(m map[float64]int)map[float64]int{
	n := make(map[float64]int,len(m))
	for v,k := range m{
		n[v] = k
	}
	return n
}

func main(){

	//data structures to store norm values go here (map, and a slice)
	treeMap := make(map[float64]int)
	var normedValues [] float64
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
	for i := firstNum; i < secondNum; i++{
		//cast i to a float
		var y float64 = float64(i)
		if(isHappy(i)){
			//need to cast i to a float
			//var y float64 = float64(i)
			//add y to normed values
			normedValues = append(normedValues,y)
			//need an int 
			var z int = int(y)
			//call breakdown function
			breakdown(z,normedValues)
			var sum float64 = 0
			//declared this variable to access elements of the slice
			var normedValuesLength = len(normedValues)
			for a := 0; a < normedValuesLength; a++{
				
				sum = sum + math.Pow(normedValues[a],2)
			}
			sum2 := math.Sqrt(sum)
			//this line possibly bad?
			//treeMap[sum] = treeMap[y]
			treeMap[y] = treeMap[sum2]
			//fmt.Println(sum2)
			//sort.Float64s(normedValues)
			//sort.Sort(sort.Reverse(sort.Float64s(normedValues)))
			//sort.Float64s(normedValues)
			//fmt.Println(normedValues)
			
			//clear the slice to re-allocate memory
			normedValues=nil
			
		}
		//call print reverse treemap method here
		sort.Sort(sort.Reverse(treeMap))
		printReverseTreeMap := printReverseTreeMap(treeMap)
		//printMap := treeMap[float64(i)]
		//fmt.Println(printMap)
		fmt.Println(printReverseTreeMap)
	}
	
}



