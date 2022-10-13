package main
//JARRETT NOBLES
//CSC330
import (
	"fmt"
	"sort"
)
import "math"

//import "sort"
var normedValues [] float64
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
		var q float64 = float64(n)
		normedValues = append(normedValues,q)
		if val, ok := s[n]; ok {
			_ = val
			return false
		}
		s[n] = struct{}{}
	}
	return false
}

//breaks down the happy numbers and solve for the norms 
func breakdown(n int , normedValues[] float64){
	var a float64 = 0
	var digit int =0
	for n >0{
		digit = n%10
		n = int(n/10)
		var x float64 = float64(digit)
		a = a+ math.Pow(x, 2)
	}
	normedValues = append(normedValues,a )
	var b int = int(a)
	if b!=1 {
		breakdown(b,normedValues)
	}

}

//print reverse map function
func reverseMap(m map[float64]int) map[float64]int {
	n := make(map[float64]int, len(m))
	for v, k := range m {
		n[(v)] = k
	}
	return n
}

func main(){
	//data structures to store norm values go here (map, and a slice)
	treeMap := make(map[float64]int)
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
	for i := firstNum; i <=secondNum ; i++{
		//cast i to a float
		var y = float64(i)
		normedValues = nil
		if(isHappy(i)){
			var z int = int(y)
			normedValues = append(normedValues,float64(i))
			breakdown(z,normedValues)
			var sum float64 = 0
			for a := 0; a < (len(normedValues)); a++{
				sum = sum + math.Pow(normedValues[a],2)
			}
			sum2 := 0.000
			sum2 = math.Sqrt(sum)
			treeMap[sum2] = int(y)
		}
	}
	count:=0
	//sorting and printing happen here 
	 keys := make([]float64, 0)
	for k, _ := range treeMap {
		keys = append(keys, k)
	}
	sort.Sort(sort.Reverse(sort.Float64Slice(keys)))
	if len(treeMap) == 0 {
		fmt.Println("NOBODIES HAPPY!")
	} else{
		for _, k := range keys {
			if count !=10{
				fmt.Println(treeMap[k])
				count++
			}
		}
	}
}



