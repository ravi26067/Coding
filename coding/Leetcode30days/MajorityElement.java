import java.util.Scanner;

/**
 * @author ravik 
 * In this problem we have to find the element which occurs more than n/2 times. Here we are assuming that number could be both positive
 * as well as negative. We are solving using two different approaches
 * 1) Using Map, we are storing the number as the key and its count as its value, when we will get count more than n/2 we will return the element.
 * 2) Moore's voting algorithm:
 * It only works for majority element does exists in this array.
 * We are taking majority index as 0, count as 1, and start comparing from index 1, if nums[i] == nums[majind] then increase count, else decrease.
 * There will be one situation when count becomes 0, then we will set majind to i+1(next index of current index) and set count =1.
 * Here we are doing this logic because we want any element whose occurance is greater than n/2, so if there is any such element, definitely at last
 * it will be present in majind.
 */
public class MajorityElement {

//	public int majorityElement(int[] nums) {
//		Map<Integer,Integer> mp = new TreeMap<Integer, Integer>();
//		int temp = 0;
//		int n = nums.length;
//		if(n==1)
//            return nums[0];
//		for(int i=0;i<n;i++) {
//			if(mp.containsKey(nums[i])) {
//				temp = mp.get(nums[i]);
//				temp++;
//				if(temp> n/2)
//					return nums[i];
//				mp.put(nums[i], temp);
//			}
//			else {
//				mp.put(nums[i], 1);
//			}
//		}
//		return 0;
//	}
	
	public int majorityElement(int[] nums) {
		int cnt = 1;
		int majind = 0;
		for(int i=1;i< nums.length;i++) {
			
			if(nums[majind]==nums[i])
				cnt++;
			else
				cnt--;
			
			if(cnt==0) {
				majind = ++i;
				cnt++;
			}
		}
		return nums[majind];
	}

	public static void main(String[] args) {

		MajorityElement maj = new MajorityElement();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(maj.majorityElement(arr));
			t--;
		}
	}
}
