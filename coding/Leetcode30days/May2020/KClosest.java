import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ravik
 * We have taken Pair where we are storing the square and the actual elements of array. Here we are creating collection of this pair and 
 * we are using comparator to sort this in ascending order. Then we are iterating it k times and copying the first k element in final output 
 * array.
 */
public class KClosest {
	
	class Pair{
		long square;
		int arr[] = new int[2];
		
		public Pair(long square, int[] arr) {
			this.square = square;
			this.arr[0] = arr[0];
			this.arr[1] = arr[1];
		}

		public long getSquare() {
			return square;
		}

		public int[] getArr() {
			return arr;
		}
		
	}

	public int[][] kClosest(int[][] points, int K) {
		int ans[][] = new int[K][2];
		List<Pair> ls = new ArrayList<>();
		for(int i=0;i<points.length;i++) {
			long sq = (points[i][0] * points[i][0]) + (points[i][1]*points[i][1]);
			ls.add(new Pair(sq, points[i]));
		}
		
		Collections.sort(ls, new Comparator<Pair>() {
			@Override
			public int compare(Pair left, Pair right) {
				
				return (int) (left.getSquare() - right.getSquare());
			}
		});
		
		for(int i=0;i<K;i++) {
			ans[i][0] = ls.get(i).getArr()[0];
			ans[i][1] = ls.get(i).getArr()[1];
		}
		return ans;
	}

	public static void main(String[] args) {
		KClosest kc = new KClosest();
		int K = 2;
		int arr[][] = { {3,3},{5,-1},{-2,4} };
		System.out.println(kc.kClosest( arr,K));
	}

	/*
	 * 1-1-1 2-10-1 3-11-2 4-100-1 5-101-2 6-110-2 7-111-3 8-1000-1 9-1001-2
	 * 10-1010-2 11-1011-3 12-1100-2 13-1101-3 14-1110-3 15-1111-4
	 */
}
