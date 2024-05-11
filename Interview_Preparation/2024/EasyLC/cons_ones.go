func findMaxConsecutiveOnes(nums []int) int {

    res:=0
    consOne:=0
    // Iterate over arrau, when recieves 0 then make counter 0. Every iteratio 
    // check max of res and consOne. Return res.
    for _,val:=range (nums){
        if val==1{
            consOne++
        }else{
            consOne=0
        }

        res = max(res,consOne)
    }
    return res
}
