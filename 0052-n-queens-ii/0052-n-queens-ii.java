
class Solution {
    
    public int totalNQueens(int n) {
        row = new boolean[n];
        col = new boolean[n];
        diag = new boolean[n+n-1];
        antiDiag = new boolean[n+n-1];
        int ans = nQueensSolver2(0,0,n);
        return ans;
    }
    
    int dir[][] = {{-1,0},{-1,-1},{0,-1},{-1,1}};
    boolean[] row , col , diag , antiDiag;
    
    boolean isSafe2(int r , int c , int n){
        if(row[r]){
            return false;
        }
        if(col[c]){
            return false;
        }
        if(diag[r-c+n-1]){
            return false;
        }
        if(antiDiag[r+c]){
            return false;
        }
        
        return true;
    }
    void toggle(int r,int c,int n){
        row[r] = !row[r];
        col[c] = !col[c];
        diag[r-c+n-1] = !diag[r-c+n-1];
        antiDiag[r+c] = !antiDiag[r+c];
    }
    
    
    int nQueensSolver2(int r , int qpsf , int n){
        if(r == n || qpsf == n){
            if(qpsf == n){
                return 1;

            }
            return 0;
        }
        int count = 0;
        
        for(int c = 0; c<n ; c++){
            if(isSafe2(r, c, n)){
                toggle(r ,c ,n);
                count += nQueensSolver2(r+1 , qpsf+1 , n);
                toggle(r, c, n);
            }
        }
        return count;
    }
}