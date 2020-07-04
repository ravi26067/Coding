class Solution {
    public int nthUglyNumber(int n) {	
		if(n < 0)
			return Integer.MIN_VALUE;
			
		PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
		HashSet<Long> set = new HashSet<Long>();
		int count = 0;
		long result = Integer.MIN_VALUE;
		minHeap.add(1L);
		set.add(1L);
		while(count < n){
			++count;
			result = minHeap.poll();
			if(set.add(result * 2))
				minHeap.add(result * 2);
				
			if(set.add(result * 3))
				minHeap.add(result * 3);
				
			if(set.add(result * 5))
				minHeap.add(result * 5);
		}
		
		return (int)result;
    }
}