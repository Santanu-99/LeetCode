class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        char[][] mat = new char[n][n];
        for(int r=0;r<n; r++){
            for(int c=0;c<n;c++){
                mat[r][c]='.';
            }
        }
        ans = new ArrayList<>();
        nQueensSolver2(mat,0,0,n);
        return ans;
    }
    
    int dir[][] = {{-1,0},{-1,-1},{0,-1},{-1,1}};
    
    boolean isSafe(char[][] mat, int r , int c){
        int n = mat.length;
        for(int d=0; d<dir.length; d++){
            for(int j=1; j<mat.length ;j++){
                int nr = r + j*dir[d][0];
                int nc = c + j*dir[d][1];
                if(0<=nr && 0<=nc && nr<n && nc < n ){
                    if(mat[nr][nc] != '.'){
                        return false;
                    }
                }
                else{
                    break;
                }
            }
        }
        return true;
    }
    
    void addToAns(char[][] mat){
        
        List<String> newAns = new ArrayList<>();
        for(int r=0;r<mat.length;r++){
            newAns.add(new String(mat[r]));
        }
        ans.add(newAns);
    }
    
    void nQueensSolver2(char[][] mat , int r , int qpsf , int n){
        if(r == n || qpsf == n){
            if(qpsf == n){
                addToAns(mat);  
                // System.out.println();

            }
            return;
        }
        
        for(int c = 0; c<n ; c++){
            if(isSafe(mat, r, c)){
                mat[r][c] = 'Q';
                nQueensSolver2(mat,r+1 , qpsf+1 , n);
                mat[r][c] = '.';
            }
        }
    }
}