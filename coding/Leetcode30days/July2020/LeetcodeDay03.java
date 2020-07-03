import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Here we are using just loop and we have observed that after every 14
 * repetition same thing we are getting.
 */

public class Solution {

	public int[] prisonAfterNDays(int[] cells, int N) {

		if (N == 0)
			return cells;
		Map<Integer, int[]> mp = new LinkedHashMap();

		for (int i = 1; i <= 14; i++) {
			int temp[] = new int[cells.length];
			for (int j = 1; j < 7; j++) {
				if ((cells[j - 1] ^ cells[j + 1]) == 0)
					temp[j] = 1;
				else
					temp[j] = 0;
			}
			cells = temp;
			mp.put(i, cells);
		}

		long key = N % 14;
		return mp.get((N % 14 == 0) ? 14 : N % 14);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int cells[] = { 0, 1, 0, 1, 1, 0, 0, 1 };
		cells = sol.prisonAfterNDays(cells, 7);
		// System.out.println(cells);
		for (int i : cells)
			System.out.print(i + " ");
		System.out.println();
	}

}