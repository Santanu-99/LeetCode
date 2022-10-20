
class Solution {
    
    public int totalNQueens(int n) {
        row = 0;
        col = 0;
        diag = 0;
        antiDiag = 0;
        int ans = nQueensSolver2(0,0,n);
        return ans;
    }
    
    int row , col , diag , antiDiag;
    
    boolean isSafe2(int r , int c , int n){

        if((row & (1<<r)) != 0){
            return false;
        }
        if((col & (1<<c)) != 0 ){
            return false;
        }
        if( (diag & (1 << (r-c+n-1))) != 0 ){
            return false;
        }
        if((antiDiag & (1 << (r+c))) != 0 ){
            return false;
        }
        
        return true;
    }
    void toggle(int r,int c,int n){
        row ^=  (1 << r);
        col ^=  (1 << c);
        diag ^= ( 1 << (r-c+n-1));
        antiDiag ^= (1 << (r+c));
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