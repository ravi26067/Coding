/**
 * Here we are using bitwise operators. We are shifting result bits to left and
 * doing or operation with 1 and shifting n bits to right.
 */
class Solution {

	public int reverseBits(int n) {

		int reverse = 0;

		for (int i = 0; i < 32; i++) {
			reverse = reverse << 1 | n & 1;
			n = n >> 1;
		}
		return reverse;

		// one liner answer in which we are using inbuilt reverse method
		// return Integer.reverse(n);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
	}

}
