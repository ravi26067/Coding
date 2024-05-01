func canPartition(nums []int) bool {
    
    sum:=0
    n := len(nums)

    //calculate the sum first
    for _,v:=range(nums){
        sum+=v
    }

    initialize the matrix for tabulation approach
    arr:=make([][]bool,n+1)

    // similar to subset sum problem, first calculate the sum
    for i:=0;i<n+1;i++{
        arr[i] = make([]bool,sum+1)
        //i+=1
    }

    //if sum is not even then return false as we need two subsets having equal sum. For that the sum should be even.
    if sum%2!=0{
        return false
    }

    // now divide the sum by 2 and apply the approach of subset sum problem
    sum = sum/2

    // One dimention of matrix will be the index of arrays from 0 - N and other is the sum from 0 to sum. 
    // If sum is 0 then return true and if value of i to n is 0 return false as we can't get sum with emoty array. 
    // Make or condition by including or excluding the current element if it's less than sum else exclude it if its greater.

    for i:=0;i<n+1;i++{
        for j:=0;j<sum+1;j++{
            if j==0{
                arr[i][j]=true
            }else if i==0{
                arr[i][j]=false
            }else if nums[i-1]<=j{
                arr[i][j] = (arr[i-1][j] || arr[i-1][j-nums[i-1]])
            }else{
                arr[i][j] = arr[i-1][j]
            }
        }
    }
    //return last position to get the result of entier array and sum.
    return arr[n][sum] 
}
