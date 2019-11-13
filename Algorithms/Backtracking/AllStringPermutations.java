/**
 * @author kumarr144
 *
 *	Class contain implementation of all possible permutation of a string. String of length n has n! permutations. Time complexity O(n*n!)
 *	We are using backtracking here. We are fixing the substring and swapping remaining the characters.
 */
public class AllStringPermutations {
	
	public static void permuteString(String str,int l,int r) {
		
		if(l==r)
			System.out.println(str);
		else {
			
			for(int i=l;i<=r;i++) {
				str = swap(str, l, i);
				permuteString(str,l+1, r);
				str = swap(str, l, i); // for backtracking 
			}
			
		}
		
	}
	
	public static String swap(String str,int i,int j) {
		char [] tempArr = str.toCharArray();
		char temp = tempArr[i];
		tempArr[i] = tempArr[j];
		tempArr[j] = temp;
		return String.valueOf(tempArr);
		
		
	}
	

	public static void main(String[] args) {
		
		String str = "ABC";
		permuteString(str, 0 ,str.length()-1);
	}

}
