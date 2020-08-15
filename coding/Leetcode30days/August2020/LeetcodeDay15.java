class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1])
                    return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        int res = 0, p = 0;
        for (int i = 1; i < n; i++) {
            int[] prev = intervals[p];
            int[] curr = intervals[i];
			/* Skip the non-overlapping interval */
            if (prev[1] <= curr[0])
                p = i;
            else
                res++;
        }

        return res;
    }
}
