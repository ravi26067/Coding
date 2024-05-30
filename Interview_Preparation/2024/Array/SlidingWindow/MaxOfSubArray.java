import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// problem: https://www.geeksforgeeks.org/problems/ipl-2021-match-day-2--141634/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

public class MaxOfSubArray {
    // non optimal approach
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        while (j < n) {
            pq.add(arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                res.add(pq.peek());
                pq.remove(arr[i]);
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        ArrayList<Integer> res = max_of_subarrays(arr, 9, 3);
        System.out.println(res);
    }
}
