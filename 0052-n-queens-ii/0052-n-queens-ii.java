class Solution {
    public int totalNQueens(int n) {
        boolean mat[][] = new boolean[n][n];
        int ans = getCount(mat, 0,0,n,n*n);
        return ans;
    }
    
    int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1}};
    public boolean isSafe(boolean[][] mat,int r, int c){
        for(int d=0; d<dir.length; d++){
            for(int j=1;j<mat.length;j++){
                int nr = r + dir[d][0]*j;
                int nc = c + dir[d][1]*j;
                if(0<=nr && 0<=nc && nr<mat.length && nc < mat.length ){
                    if(mat[nr][nc] == true){
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
    
    
    
    public  int getCount(boolean[][] mat, int bsf, int qsf , int totQ , int totBox){
        if(bsf == totBox || qsf==totQ ){
            if(qsf == totQ){
                return 1;
            }
            return 0;
        }
        int n = mat.length;
        int count = 0;
        for(int b = bsf ; b<totBox ; b++){
            int r = b / n;
            int c = b % n;
            if(isSafe(mat, r,c)){
                mat[r][c] = true;
                count += getCount(mat, b+1, qsf+1 ,totQ , totBox);
                mat[r][c] = false;
                
            }
        }
        return count;
    }
}