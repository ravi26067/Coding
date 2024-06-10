import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n; // If the string length is less than 3, the maximum length is the length of the string itself
        
        Map<Character, Integer> charFrequency = new HashMap<>(); // Map to store the frequency of characters
        int left = 0; // Left pointer of the window
        int right = 0; // Right pointer of the window
        int maxLength = 2; // Initialize the maximum length of the substring with at least two distinct characters
        
        while (right < n) {
            char currentChar = s.charAt(right);
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1); // Update the frequency of the current character
            
            // If the number of distinct characters within the window exceeds 2, shrink the window
            while (charFrequency.size() > 2) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1); // Decrease the frequency of the character at the left pointer
                if (charFrequency.get(leftChar) == 0) charFrequency.remove(leftChar); // If the frequency becomes 0, remove the character from the map
                left++; // Move the left pointer to the right
            }
            
            // Update the maximum length of the substring found so far
            maxLength = Math.max(maxLength, right - left + 1);
            right++; // Move the right pointer to the right
        }
        
        return maxLength; // Return the maximum length of the substring with exactly two distinct characters
    }
}
