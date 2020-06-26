/**
* Here we want to find any number is reapeating or not in O(1) space and O(n) time 
* We will run loop to find cycle in an array by using fast and slow pointer.
* We will again run the loop to find the number.
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slPtr = 0;
        int ftPtr = 0;
        
        while(true){
            slPtr = nums[slPtr];
            ftPtr = nums[nums[ftPtr]];
            
            if(ftPtr==slPtr)
                break;
            
        }
        
        ftPtr = 0;
        
        while(slPtr!=ftPtr){
            slPtr = nums[slPtr];
            ftPtr = nums[ftPtr];
        }
        return ftPtr;
    }
}