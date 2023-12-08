package coding.Leetcode.2023;

public class ArrayPermutation {

    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 2, 1, 5, 3, 4 };
        ArrayPermutation ap = new ArrayPermutation();
        int[] arr = ap.buildArray(nums);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
