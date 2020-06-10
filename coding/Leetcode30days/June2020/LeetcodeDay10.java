class Solution {
    public int searchInsert(int[] nums, int target) {

		int i = 0, j = nums.length - 1;
		int mid = 0;
		while (i <= j) {
			mid = (i+j)/2;
			//System.out.println("I: "+i +" J: "+j+" M: "+mid);
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				i = mid + 1;
			} else {
				j = mid-1;
			}
		}
		
		
		if(nums[mid]<target)
			mid = mid+1;		
		
		return mid;
	}
}