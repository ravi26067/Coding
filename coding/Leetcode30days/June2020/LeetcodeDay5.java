import java.util.Random;

/**
 * We need to find the probability of each weight by sum of total weights. So
 * here we will be taking array with storing the sum till element i. eg. we have
 * array 1,2,3 = > {1,3,6} by this (1,1+2,1+2+3). Here we will generate random
 * number between 0-1 and multiply it by sum i.e 6. we will use binary search to
 * find the closest index.
 */
class Solution {

	int[] W;

	public Solution(int[] w) {
		W = new int[w.length];

		W[0] = w[0];
		for (int i = 1; i < w.length; i++)
			W[i] = W[i - 1] + w[i];
	}

	int pickIndex() {
		Random rndm = new Random();
		int len = W.length;
		double rndmNum = rndm.nextDouble() * W[len - 1];
		int low = 0;
		int high = len - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (W[mid] < rndmNum)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}

	public static void main(String[] args) {
		int w[] = { 1, 3, 4 };
		Solution ans = new Solution(w);
		int param_1 = ans.pickIndex();
		System.out.println(param_1);
	}

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */