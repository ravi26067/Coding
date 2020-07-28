class Solution {
	public int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0) {
			return 0;
		}
		int m = tasks.length;
		int[] cnt = new int[26];
		/* Build the count array with frequency of each task */
		for (char c: tasks) {
			cnt[c - 'A']++;
		}
		Arrays.sort(cnt);
		/* Get maximum frequency task  and calculate max idle spaces*/
        int max = cnt[25]-1;
		int spaces = max * n;
		
		/* Iterate over rest of the array and reduce the idle space count */
		for (int i = 24; i >= 0; i--) {
			spaces -= Math.min(max, cnt[i]);
		}
		/* Handle cases when spaces become negative */
		spaces = Math.max(0, spaces);
		return tasks.length + spaces;
	}
}
