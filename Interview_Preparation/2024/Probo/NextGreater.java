class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Get the length of the input array
        int n = nums.length;
        
        // Initialize an array to store the result
        int res[] = new int[n];
        
        // Initialize a stack to keep track of indices
        Stack<Integer> st = new Stack();
        
        // Iterate through the concatenated array from right to left
        for(int i=(2*n-1); i>=0; i--){
            // While the stack is not empty and the top element of the stack
            // is less than or equal to the current element in the array (circular)
            while(!st.isEmpty() && st.peek() <= nums[i%n])
                // Pop elements from the stack
                st.pop();
            
            // If the current index is within the bounds of the original array
            if(i<n)
            {
                // If the stack is not empty, update the result with the top element of the stack
                if(!st.isEmpty())
                    res[i] = st.peek();
                // If the stack is empty, there is no next greater element, so assign -1
                else
                    res[i] = -1;
            }
            
            // Push the current element's value onto the stack
            st.push(nums[i%n]);
        }
        
        // Return the result array
        return res;
    }
}
