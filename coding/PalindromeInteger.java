import java.io.*;

public class PalindromeInteger {
    
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        StringBuilder input1 = new StringBuilder();
        input1.append(str);
        input1 = input1.reverse();
        System.out.println("Value of i/p1"+input1);
        String str2 = input1.toString();
        System.out.println("Value of str2"+str2);
        if(str.equals(str2))
            return true;
        else
            return false;
    }
    
	public static void main (String[] args) {
	    PalindromeInteger obj = new PalindromeInteger();
		int x = 121;
		System.out.println(obj.isPalindrome(x));
	}
}