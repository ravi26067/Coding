public class RotateImage {

    /**
     * Here we are given 2D matrix, we need to rotate it by 90 degree clockwise.
     * @param matrix
     */

        public void rotate(int[][] matrix) {
            int n = matrix.length;
            //first we will find the transpose of matrix
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            //then we will be reversing the row items that will give final result
            for(int i=0;i<n;i++){
                for(int j=0;j<n/2;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-j-1];
                    matrix[i][n-j-1] = temp;
                }
            }
        }
}
