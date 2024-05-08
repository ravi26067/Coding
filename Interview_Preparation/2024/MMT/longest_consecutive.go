func longestConsecutive(nums []int) int {
    lcs:= make(map[int]bool)
    for _,val:=range(nums){
        lcs[val]=true
    }

    max:=0
    curr:=0
    l:=len(nums)
    for _,val:=range(nums){
        curr = 0
        leng:= val+l
        if ok,_:=lcs[val-1];!ok{
            for val<leng{
                if ok1,_:=lcs[val];ok1{
                    val+=1
                    curr+=1
                }else{
                    break
                }
                
            }
            if max<curr{
                max=curr
            }
        }
    }
    return max
}
