class Solution {
    public double average(int[] salary) {
		int k = salary.length -2;
		double sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<salary.length;i++) {
			if(min>salary[i])
				min = salary[i];
			if(max<salary[i])
				max = salary[i];
			
			sum+=salary[i];
		}
		sum = (sum-(min+max))/k;
		return sum;
	}
}