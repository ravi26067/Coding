# **Dynamic Programming (LCS problems)**
## Some useful facts
We are mostly given two string and we need to find LCS. LCS stands for Largest Common Subsequence. 
Some question contains single string, where we have to find LPS (Longest Palindromic Subsequence). 
To calculate that we reverse first string and then apply LCS logic there. There are just small variations in these questions.
In these problems, we can't use two pointer approach as to use two pointer approach one string should be LCS of other.

|   Problem Statement     |   Solution  |
|:-------------------------------------------:|:------:|
| [Longest common subsequence between two strings](https://leetcode.com/problems/longest-common-subsequence/) | [LongestCommonSubs.java](https://github.com/ravi26067/Coding/blob/master/Algorithms/DP/LCS/LongestCommonSubs.java)|
| [Longest common substring between two strings](https://leetcode.com/problems/maximum-length-of-repeated-subarray/) | [MaxLength.java](https://github.com/ravi26067/Coding/blob/master/Algorithms/DP/LCS/MaxLength.java)|
| [Print LCS between two given strings](https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem) | [PrintLCS.java](https://github.com/ravi26067/Coding/blob/master/Algorithms/DP/LCS/PrintLCS.java)
