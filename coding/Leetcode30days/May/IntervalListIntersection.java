import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ravik
 * We are taking a Pair class to store the start and end of final result. We will have an overlap method to check if A and B are overlapping. If they are not ,then
 * we will not do anything just increment minimum end by 1. If it overlaps then we will store the intersection coordinates.
 */
public class IntervalListIntersection {

	class Pair {
		int start;
		int end;

		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

	}

	boolean isOverlap(int[] A, int[] B) {
		// System.out.println("isOverlap: "+ A[0] + " " + B[0]);
		// System.out.println(A[1] + " " + B[1]);
		int front = Math.max(A[0], B[0]);
		int back = Math.min(A[1], B[1]);
		if (back - front >= 0) {
			// System.out.println("true"+ (back-front));
			return true;
		} else {
			// System.out.println("false" + (back-front));
			return false;
		}

	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<Pair> ls = new ArrayList<Pair>();
		int i = 0;
		int j = 0;

		while (i < A.length && j < B.length) {

			if (isOverlap(A[i], B[j])) {
				// System.out.println("Value of i: "+i + " Value of j: "+j);
				int x = Math.max(A[i][0], B[j][0]);
				int y = Math.min(A[i][1], B[j][1]);
				ls.add(new Pair(x, y));
			}
			if (A[i][1] < B[j][1])
				i++;
			else if (A[i][1] > B[j][1])
				j++;
			else {
				i++;
				j++;
			}
		}

		int l = ls.size();
		// System.out.println("Size of list: "+l);
		int ans[][] = new int[l][2];
		i = 0;
		for (Pair ps : ls) {
			ans[i][0] = ps.start;
			ans[i][1] = ps.end;
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		IntervalListIntersection fc = new IntervalListIntersection();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int alen = sc.nextInt();
			int blen = sc.nextInt();
			int a[][] = new int[alen][2];
			int b[][] = new int[blen][2];
			System.out.println("Enter the elements of A:");
			for (int i = 0; i < alen; i++) {
				a[i][0] = sc.nextInt();
				a[i][1] = sc.nextInt();
			}
			System.out.println("Enter the elements of B:");
			for (int i = 0; i < blen; i++) {
				b[i][0] = sc.nextInt();
				b[i][1] = sc.nextInt();
			}

		}
	}
}
