class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int[][] dir = {{-1 , 0},{0,-1}};
        int ans = uniquePathsMemo(0,0,m-1,n-1,dp,dir);
        return ans;
    }
    
    int uniquePathsMemo(int sr ,int sc, int er , int ec , int[][] dp ,int[][] dir){
        if(sr == er && sc == ec){
            return dp[er][ec] = 1;
        }
        
        if(dp[er][ec] != 0) return dp[er][ec];
        
        int count = 0;
        for(int[] d : dir){
            int ner = er + d[0];
            int nec = ec + d[1];
            if(0<=ner && 0<=nec && ner < dp.length && nec < dp[0].length)
                count += uniquePathsMemo(sr , sc ,ner,nec,dp,dir);
        }
        
        return dp[er][ec] = count;
    }
}