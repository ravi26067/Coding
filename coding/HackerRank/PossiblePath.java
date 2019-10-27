public class PossiblePath {
	
	static boolean isPossible(int x,int y,int x1,int y1) {
		if(x==x1 && y == y1)
			return true;
		else {
			if(x>x1||y>y1)
				return false;
			else
				return (isPossible(x+y, y, x1, y1)||isPossible(x, y+x, x1, y1));
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPossible(2, 3, 13, 8));
	}
	
}
