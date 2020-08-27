class Solution {
    public int binarySearch(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= target){
                ans = mid;
                end = mid - 1;
            }else
                start = mid + 1;
        }
        return ans;
    }
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = intervals.length;
        int[] temp = new int[N];
        for(int i = 0; i < N; i++){
            temp[i] = intervals[i][0];
            map.put(temp[i], i);
        }
        Arrays.sort(temp);
        for(int i = 0; i < N; i++){
            int index = binarySearch(temp, intervals[i][1]);
            ans[i] = index == -1 ? -1 : map.get(temp[index]);
        }
        return ans;
    }
}
