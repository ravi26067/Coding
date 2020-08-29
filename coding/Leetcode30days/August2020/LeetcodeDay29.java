class Solution {

	public int gett(int[] A,int i){
		int temp=0;
		int maxv=A[0];
		for (int j=0;j<i;j++){
			if (A[j]>maxv){
				maxv=A[j];
				temp=j;
			}
		}
		return temp;
	}

	public void reverse(int []a, int k) 
	{ 
		for (int i = 0; i < k / 2; i++) 
		{ 
			int tempswap = a[i];  
				a[i] = a[k - i - 1];  
				a[k - i - 1] = tempswap;              
		}  
	} 

	public List<Integer> pancakeSort(int[] A) {

		List<Integer> ans=new ArrayList<>();
		for (int i=A.length;i>1;i--){
			int temp=gett(A,i);
			if (temp==i-1)
				continue;
			else{
				reverse(A,temp+1);
				ans.add(temp+1);
				reverse(A,i);
				ans.add(i);
				}
			}
		return ans;
	}
}
