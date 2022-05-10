class Solution {
    
    private static boolean inRange(int i,int j,int n,int m){
        if(0<=i && 0<=j && i<=n && j<=m){
            return true;
        }
        
        return false;
    }

    
    private int getPaths(int sr,int sc,int dr,int dc,int[][] dir,int[][] dp){
        
        if(sr==dr && sc == dc){
            return 1;
        }
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        
        int count = 0;
        for(int d=0;d<dir.length;d++){
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            if(inRange(nr,nc,dr,dc)){
                count += getPaths(nr,nc,dr,dc,dir,dp);
            }
        }
        
        dp[sr][sc] = count;
        
        return count;
        
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dir = {{0,1},{1,0}};
        int[][] dp = new int[m][n];
        int count = getPaths(0,0,m-1,n-1, dir,dp);
        return count;
    }
}