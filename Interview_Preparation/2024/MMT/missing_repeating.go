

func nextGreaterElement(nums1 []int, nums2 []int) []int {
    ngMap:=make(map[int]int)
    res:=make([]int,len(nums1))
    stack:=make([]int,0)

        for _,num:=range(nums2){
            
            for len(stack)>0 && num>stack[len(stack)-1]{
                l:=len(stack)
                ngMap[stack[l-1]] = num
                stack= stack[:l-1]
            }
            stack= append(stack,num)
        }

        for i,num:=range(nums1){
            if val,ok:=ngMap[num];ok{
                res[i]=val
            }else{
                res[i]=-1
            }
        }
        return res
}

