func maxSubArray(nums []int) int {
    maxSub:=nums[0]
    currSum:=0

    for _,num:=range(nums){
        if currSum<0{
            currSum=0
        }
        currSum +=num
        if maxSub<currSum{
            maxSub=currSum
        }
    }
    return maxSub
}
