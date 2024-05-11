func moveZeroes(nums []int)  {
    i:=0
    j:=0

    // Keep j pointer for traversing the array and i pointer for maintaining non zero count. 
    for j<len(nums){
        if nums[j]!=0{
            swap(nums,i,j)
            i++
        }
        j++
    }
}

func swap(nums[]int,i,j int){
    tmp:=nums[i]
    nums[i] = nums[j]
    nums[j] = tmp
}
