class Solution {
    /**
     * Here we are using DFS traversal recursively. We are checking for the corner rows and columns and 
     * if it is 'O' we are using DFS and making them '*'. After that we are running loop which converts
     * the remaining 'O' to 'X' and '*' to 'O'.
     */
    
    void DFS(char[][] board ,int i,int j){
        
        //for handaling boundary cases
        if(i<0 || i>=board.length || j<0 || j>board[0].length)
            return;
        
        //setting the '0' to '*' for identification later
        if(board[i][j]=='O')
            board[i][j]='*';
        
        
        //recursively calling (DFS)
        if( i>0 && board[i-1][j]=='O' )
            DFS(board,i-1,j);
        
        if( i < board.length-1 && board[i+1][j]=='O' )
            DFS(board,i+1,j);
        
        if( j>0 && board[i][j-1]=='O' )
            DFS(board,i,j-1);
        
        if( j<board[0].length-1 && board[i][j+1]=='O' )
            DFS(board,i,j+1);
        
        return;
            
    }
    
    
    public void solve(char[][] board) {
        
        //if lenght is 0 we will directly return 
        if(board.length==0 || board[0].length==0)
            return;
        
        //cheking for values in first and last rows
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')
                DFS(board,i,0);
            if(board[i][board[0].length-1]=='O')
                DFS(board,i,board[0].length-1);
        }
        
        //checking for values in first and last columns
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O')
                DFS(board,0,i);
            if(board[board.length-1][i]=='O')
                DFS(board,board.length-1,i);
        }
        
        //generating final results
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                else if(board[i][j]=='*')
                    board[i][j] = 'O';
            }
        }
        
        
    }
}