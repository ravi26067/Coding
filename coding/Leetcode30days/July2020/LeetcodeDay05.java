/**
 * Here we are doing xor operation bitwise and adding it to the counter.
 */
class Solution {
    public int hammingDistance(int x, int y) {
		
		int cnt = 0;
		while(x>0 || y>0) {
			cnt += ((x&1) ^ (y&1));
			x = x>>1;
			y = y>>1;
		}
		
		return cnt;
	}
}