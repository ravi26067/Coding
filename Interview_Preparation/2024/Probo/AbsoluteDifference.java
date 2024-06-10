class Solution {
    
    public static int longestSubseq(int n, int[] a) {
        // Initialize a HashMap to store the length of the longest subsequence ending at each element
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // Initialize the maximum length of the subsequence to 1 (as each element itself forms a subsequence of length 1)
        int max = 1;
        
        // Iterate through each element of the array
        for(int i = 0; i < n; i++) {
            // Calculate the length of the longest subsequence ending at the current element
            // The length of the subsequence is the maximum of the lengths of the subsequence ending at a[i] - 1 and a[i] + 1 plus 1
            int currentLength = Math.max(map.getOrDefault(a[i] - 1, 0), map.getOrDefault(a[i] + 1, 0)) + 1;
            
            // Update the length of the longest subsequence ending at the current element in the map
            map.put(a[i], currentLength);
            
            // Update the maximum length if needed
            max = Math.max(max, currentLength);
        }
        
        // Return the maximum length of the subsequence
        return max;
    }
}
