public class JwellStones{
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        int temp =0;
        for(int i=0;i < S.length();i++){
            temp = J.indexOf(S.charAt(i));
            if(temp!=-1)
                ans++;
        }
        return ans;
    }
	
	public static void main(String[]args[]){
		JwellStones obj1 = new JwellStones();
		String J = "aA";
		String S = "aaaAAAbbbb";
		System.out.println(obj1.numJewelsInStones(J,S));
	}
}