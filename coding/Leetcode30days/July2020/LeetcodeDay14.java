/**
 * Here we are calculating position of hour hand and minutes hand and returning
 * the max angle.
 */
class Solution {

	public double angleClock(int hour, int minutes) {

		double angle = 0;
		double minAngle = minutes * 6;
		double hrAngle = hour * 30 + (minAngle / 360 * 30);
		hrAngle = hrAngle % 360;

		angle = Math.abs(hrAngle - minAngle);

		angle = Math.min(angle, 360 - angle);

		return angle;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int hour = 12;
		int minutes = 30;
		System.out.println(sol.angleClock(hour, minutes));
	}

}
