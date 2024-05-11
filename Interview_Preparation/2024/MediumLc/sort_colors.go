func sortColors(nums []int)  {
    zero_count:=0
    ones_count:=0
    twos_count:=0
    for _,num:=range(nums){
        if num==0{
            zero_count++
        }else if num==1{
            ones_count++
        }else if num==2{
            twos_count++
        }
    }
    i:=0

    for i<zero_count{
        nums[i]=0
        i++
    }
    for i<zero_count+ones_count{
        nums[i]=1
        i++
    }
    for i<zero_count+ones_count+twos_count{
        nums[i]=2
        i++
    }
}
