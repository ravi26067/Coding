/**
* Here we can see that for n = 3 we can have 3 cases
* 1.Set 1 as root, we have two nodes on the right which 
* can be arranged in n=2 ways and left side of 1 is 0 which 
* can be arranged in n=0 ways. Product of n=0* n=2 will give 
* the result.
* 2. Set 2 as root, we are remaining with only 1 way.
* 3. Set 3 as root, we are having 2 nodes on right so 2 ways.
*/

class Solution {
    public int numTrees(int n) {
        int total[] = new int[n+1];
        total[0] = 1;
        total[1] = 1;
        
        for(int i=2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                total[i] += total[j-1] * total[i-j];
            }
        }
        
        
        return total[n];
    }
}