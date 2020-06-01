import java.util.Scanner;

/**
 * @author ravik
 * Just we need to create an array of size 256 which will store the count of letters based on their ascii values using first loop.
 * Another loop we will run and once we get any letter count as 1 we will return its index and break from the loop and otherwise if 
 * we don't find any letter with count 1 then deafult ans = -1 will be returned.
 */
public class FirstUnique {

	public int firstUniqChar(String s) {
		int ans = -1;
		int [] arr = new int [256];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)]++;
		}
		for(int i=0;i<s.length();i++) {
			if(arr[s.charAt(i)]==1)
			{
				ans = i;
				break;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		FirstUnique fstun = new FirstUnique();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0) {
			String s = sc.nextLine();
			System.out.println(fstun.firstUniqChar(s));
			t--;
		}
	}
}
