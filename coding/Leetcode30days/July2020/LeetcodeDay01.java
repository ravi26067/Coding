class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
	
	//very slow solution
	/*
	public int arrangeCoins(int n) {
        long i=0;
        while((i*(i+1))/2 <=n )
            i++;
        
        return (int)i-1;
    }
	*/
}