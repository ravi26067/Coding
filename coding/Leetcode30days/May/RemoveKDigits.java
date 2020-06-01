import java.util.Scanner;
import java.util.Stack;

public class RemoveKDigits {

	public String removeKdigits(String num, int k) {
		int n = num.length();
		Stack<Character> stack = new Stack<Character>();
		
		int i = 0;
		
		if(k==n)
			return "0";
		
		while(i<n) {
			
			while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}
		
		while(k>0)
		{
			stack.pop();
			k--;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		sb.reverse();
		
		while(sb.length() > 1 && sb.charAt(0)=='0')
			sb.deleteCharAt(0);
		
		return sb.toString();
	}

	public static void main(String[] args) {

		RemoveKDigits ps = new RemoveKDigits();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		if (sc.hasNext())
			sc.nextLine();
		while (t > 0) {
			String input = sc.nextLine();
			System.out.println(input.length());
			t--;
		}
	}
}
