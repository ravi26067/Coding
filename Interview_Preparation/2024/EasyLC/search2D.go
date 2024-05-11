func searchMatrix(matrix [][]int, target int) bool {
    l:= len(matrix)
    m:=len(matrix[0])

    // Search for which position the current target lies
    for i:=0;i<l;i++{
        if target >= matrix[i][0] && target <= matrix[i][m-1]{
            x:=0
            y:=m-1

            // Binary search to find the element 
            for x<=y{
                n:=(x+y)/2
                if matrix[i][n]==target{
                    return true
                }else if matrix[i][n]<target{
                    x=n+1
                }else{
                    y=n-1
                }
            }
        }
    }
    return false
}
