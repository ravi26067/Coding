// https://leetcode.com/problems/jump-game/
func canJump(nums []int) bool {

    n:=len(nums)
    if n==1{
        return true
    }
    last:=n-1
    for i:=n-2;i>=0;i--{
        if nums[i]+i<last{
            
        }else{
            last = i
        }
    }
    if last==0{
        return true
    }else{
        return false
    }
    return true
}
