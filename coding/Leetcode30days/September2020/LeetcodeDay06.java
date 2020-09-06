class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int largestOverlap = 0;
        for (int row = -A.length + 1; row < A.length; row++)
            for (int col = -A[0].length + 1; col < A[0].length; col++)
                largestOverlap = Math.max(largestOverlap, overlappingOnes(A, B, row, col));
        return largestOverlap;
    }

    public int overlappingOnes(int[][] A, int[][] B, int rowOffset, int colOffset) {
        int overlapOnes = 0;
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                if ((row + rowOffset < 0 || row + rowOffset >= A.length) || (col + colOffset < 0 || col + colOffset >= A.length) || (A[row][col] + B[row + rowOffset][col + colOffset] != 2))
                    continue;
                overlapOnes++;
            }
        }
        return overlapOnes;
    }
}