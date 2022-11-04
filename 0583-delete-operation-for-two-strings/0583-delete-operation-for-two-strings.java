class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int dp[][] = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        int count = getLongestCommonSubseq(word1,word2, m , n,dp);
        int ans = word1.length() + word2.length() - 2*count;
        return ans;
    }
    
    int getLongestCommonSubseq(String word1, String word2,int m ,int n, int[][] dp){
        if(m==0 || n==0){
            return dp[m][n]=0;
        }
        
        if(dp[m][n]!=-1) return dp[m][n];
        
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return dp[m][n]=getLongestCommonSubseq(word1,word2,m-1 ,n-1 ,dp)+1;
        }
        else{
            return dp[m][n]=Math.max(
                getLongestCommonSubseq(word1,word2, m-1, n, dp),
                getLongestCommonSubseq(word1,word2, m, n-1, dp)
            );

        }
        
    }
}