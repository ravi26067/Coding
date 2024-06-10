import java.util.HashMap;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // HashMap to store the length of the longest subsequence ending with a specific value
        HashMap<Integer, Integer> map = new HashMap<>();
        // Variable to keep track of the maximum length of any subsequence found so far
        int max = 1;

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i]; // Current element in the array
            int previous = current - difference; // The expected previous element in the subsequence
            
            // If the map contains the previous element, it means we can extend the subsequence
            if (map.containsKey(previous)) {
                int count = map.get(previous); // Get the length of the subsequence ending with 'previous'
                // Update the map with the current element and the new length of the subsequence
                map.put(current, count + 1);
                // Update the maximum length found so far
                max = Math.max(max, count + 1);
            } else {
                // If the previous element is not found, start a new subsequence with the current element
                map.put(current, 1);
            }
        }
        // Return the maximum length of the subsequence found
        return max;
    }
}
