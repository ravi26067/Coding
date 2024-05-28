import java.util.ArrayList;

public class MaximumSumSubarray {

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long sum = 0;
        long maxSum = 0;
        int i = 0;
        int j = 0;
        while (j < N) {
            sum += Arr.get(j);

            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                maxSum = Math.max(maxSum, sum);
                sum -= Arr.get(i);
                ;
                i++;
                j++;
            }
        }
        return maxSum;
    }

    /*
     * static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
     * long sum = 0;
     * long maxSum = 0;
     * for (int i = 0; i < K; i++) {
     * sum += Arr.get(i);
     * }
     * // System.out.println("Sum:"+sum);
     * maxSum = sum;
     * for (int i = 1; i <= N - K; i++) {
     * 
     * sum = sum - Arr.get(i - 1);
     * sum = sum + Arr.get(i + K - 1);
     * 
     * // System.out.println("Sum:"+sum);
     * if (sum > maxSum) {
     * maxSum = sum;
     * }
     * }
     * return maxSum;
     * }
     */

}
