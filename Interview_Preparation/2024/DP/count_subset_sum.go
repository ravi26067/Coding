//problem link: https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/



// CountSubsetSum Count number of subsets
func CountSubsetSum(arr []int, sum int) int {
	n := len(arr)
	return countsstabulation(arr, n, sum)
}

// using recurssion
func countss(arr []int, n int, sum int) int {
	if sum == 0 {
		return 1
	} else if n == 0 {
		return 0
	} else if arr[n-1] <= sum {
		return countss(arr, n-1, sum-arr[n-1]) + countss(arr, n-1, sum)
	} else {
		return countss(arr, n-1, sum)
	}
}

// using tabulation technique
func countsstabulation(arr []int, n int, sum int) int {
	dp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, sum+1)
	}

	for i := 0; i < n+1; i++ {
		for j := 0; j < sum+1; j++ {
			if j == 0 {
				dp[i][j] = 1
			} else if i == 0 {
				dp[i][j] = 0
			} else if arr[i-1] <= j {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]]
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}
	return dp[n][sum]
}
