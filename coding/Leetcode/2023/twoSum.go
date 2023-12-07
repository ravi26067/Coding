package main

import (
	"fmt"
)

func main() {
	nums := []int{3, 3}
	target := 6

	result := twoSum(nums, target)
	fmt.Println("Indexes are: ", result)
}

func twoSum(nums []int, target int) []int {
	valMap := make(map[int]int)
	var arr []int

	for i, v := range nums {

		val, ok := valMap[target-v]

		// we also need to check that both index should not be same like [3, 2, 4] in this case 6-3 is 3 and its already
		// stored when we are checking the other part
		if ok {
			arr = append(arr, val)
			arr = append(arr, i)
			break
		}

		// store after checking the valid condition for two sum
		valMap[v] = i

	}
	return arr
}
