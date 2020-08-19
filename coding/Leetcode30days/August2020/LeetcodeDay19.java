class Solution {
    public String toGoatLatin(String S) {
		String[] arr = S.split(" ");
		String append = "a";
		S = "";
		
		for(int i=0;i<arr.length;i++) {
			String tmp = arr[i];
			if(tmp.charAt(0) == 'a' || tmp.charAt(0) == 'e' || tmp.charAt(0) == 'i' || tmp.charAt(0) == 'o' || tmp.charAt(0) == 'u' ||
					tmp.charAt(0) == 'A' || tmp.charAt(0) == 'E' || tmp.charAt(0) == 'I' || tmp.charAt(0) == 'O' || tmp.charAt(0) == 'U') {
				arr[i] = arr[i] + "ma" + append;
			}else {
				arr[i] = arr[i].substring(1) + tmp.charAt(0) + "ma" + append;
			}
            if(i==arr.length-1)
                S += arr[i] ;
            else
			    S += arr[i] + " ";
			append = append + "a";
		}
		
		return S;
	}
}
