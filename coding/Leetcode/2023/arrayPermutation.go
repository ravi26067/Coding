func buildArray(nums []int) []int {
	len := len(nums)
	arr := make([]int, len)

	for i := 0; i < len; i++ {
		arr[i] = nums[nums[i]]
	}
	return arr
}