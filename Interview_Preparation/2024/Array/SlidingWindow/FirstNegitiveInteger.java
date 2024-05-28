import java.util.LinkedList;
import java.util.Queue;

public class FirstNegitiveInteger {

    public long[] printFirstNegativeInteger(long A[], int N, int K) {

        long res[] = new long[N - K + 1];
        Queue<Long> queue = new LinkedList<>();

        int i = 0;
        int j = 0;
        int k = 0;

        while (j < N) {
            if (j - i + 1 < K) {
                if (A[j] < 0) {
                    queue.add(A[j]);
                }
                j++;
            } else if (j - i + 1 == K) {

                if (A[j] < 0) {
                    queue.add(A[j]);
                }

                if (queue.size() == 0) {
                    res[k] = 0;
                } else {
                    res[k] = queue.peek();
                }
                if (queue.size() != 0 && A[i] == queue.peek()) {
                    queue.poll();
                }
                i++;
                j++;
                k++;
            }
        }

        return res;
    }

    public void printArray(long A[]) {
        for (long val : A) {
            System.out.print(val + " ");
        }
        System.err.println();
    }

    public static void main(String[] args) {
        FirstNegitiveInteger cm = new FirstNegitiveInteger();
        long arr[] = { -8, 2, 3, -6, 10 };
        long[] res = cm.printFirstNegativeInteger(arr, 5, 2);
        cm.printArray(res);
    }
}
