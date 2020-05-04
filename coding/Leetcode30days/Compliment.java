import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Compliment {

	public int findComplement(int num) {
        int ans = 0;
        int quo = 1;
        if(num==0)
        	return 1;
        Queue<Integer> st = new LinkedList();
        while(num!=0) {
        	int tmp = num %2;
        	if(tmp==1)
        		st.add(0);
        	else
        		st.add(1);
        	num = num/2;
        }
        //System.out.println(st);
        while(!st.isEmpty()) {
        	//System.out.println("Peek: "+ st.peek());
        	if(st.peek()==1) {
        		ans = ans + quo*st.remove(); 
        	}else {
        		st.remove();
        	}
        	//System.out.println("Ans:" + ans);
        	quo *=2;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		Compliment ex = new Compliment();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();
			if(num == -1)
				break;
			System.out.println(ex.findComplement(num));
		}
		
		
		
	}

}
