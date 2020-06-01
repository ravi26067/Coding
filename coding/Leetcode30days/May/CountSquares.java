
/**
 * @author ravik
 * Here we are using dyanamic programming apporach. We are checking for every 1 weather it makes square or not. First we will cover the corner cases like first row
 * with 1's and first column with 1's. Then we will start with 1st row and 1st column and iterate.
 */

class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        for(int col=0;col< matrix[0].length;col++)
            if(matrix[0][col]==1)
                count++;
        for(int row=1;row< matrix.length;row++)
            if(matrix[row][0]==1)
                count++;
        
         for(int row=1;row< matrix.length;row++){
             for(int col=1;col< matrix[0].length;col++){
                 if(matrix[row][col]!=0){
                     int square = 1+ Math.min(Math.min(matrix[row-1][col],matrix[row][col-1]),matrix[row-1][col-1]);
                     count+=square;
                     matrix[row][col] = square;
                 }
             }
         }
        return count;
    }
}