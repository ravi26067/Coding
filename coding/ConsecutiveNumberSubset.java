public class ConsecutiveNumberSubset {

	int countSubset(int arr[]) {
		int count=1;
		Arrays.sort(arr);
		int l = arr.length;
		for(int i=0;i<l-1;i++) {
			if(arr[i]+1!=arr[i+1])
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		ConsecutiveNumberSubset obj  =new ConsecutiveNumberSubset();
		
		int arr[] = {10,45,11,100,12,46,13};
		int ans = obj.countSubset(arr);
		System.out.println("Number of subsequence: "+ans);
	}

}