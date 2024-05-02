// https://leetcode.com/problems/target-sum/
// This is exactly similar to subset with given difference  https://github.com/ravi26067/Coding/blob/master/Interview_Preparation/2024/DP/SubsetGivenDifference.java

func findTargetSumWays(nums []int, target int) int {
    
    n:= len(nums)
    
    dp:= make([][]int,n+1)

    if target<0{
        target *= -1
    }


    sum:=0

    for _,val:=range(nums){
        sum+=val
    }
    
    if (sum+target)%2!=0{
        return 0
    }

    s1:= (sum+target)/2

    for i:=0;i<n+1;i++{
        dp[i]=make([]int,s1+1)
    }

    dp[0][0] = 1
    
    
    for i:=1;i<n+1;i++{
        for j:=0;j<s1+1;j++{
            if nums[i-1]<=j{
                dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j]
            }else{
                dp[i][j] = dp[i-1][j]
            }
        }
    }

    return dp[n][s1]
}
