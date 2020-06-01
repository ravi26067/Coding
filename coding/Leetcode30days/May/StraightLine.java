class Solution {
    public boolean checkStraightLine(int[][] coordinates) {

		double slope;
		double prevslope = 0.0;

		for (int i = 1; i < coordinates.length; i++) {
			slope = (double) (coordinates[i][1] - coordinates[i - 1][1]) / (coordinates[i][0] - coordinates[i - 1][0]);
			if (i != 1) {
				if (prevslope != slope)
					return false;
			}
			prevslope = slope;
		}
		return true;
	}
}