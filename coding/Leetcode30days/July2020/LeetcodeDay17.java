class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> mp = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (mp.containsKey(nums[i])) {
				mp.put(nums[i], mp.get(nums[i]) + 1);
			} else {
				mp.put(nums[i], 1);
			}
		}
		int cnt = 0;
		int ans[] = new int[k];
		LinkedHashMap<Integer, Integer> reversemp = new LinkedHashMap<Integer, Integer>();
		mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reversemp.put(x.getKey(), x.getValue()));

		for (Map.Entry<Integer, Integer> it : reversemp.entrySet()) {
			if (cnt == k)
				break;
			ans[cnt] = it.getKey();
            cnt++;
		}

		return ans;
	}
}