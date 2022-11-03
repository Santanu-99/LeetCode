class Solution {
    public int longestPalindromeSubseq(String s) {
        int m= s.length();
        int[][] dp = new int[m][m];
        for(int[] arr : dp ){
            Arrays.fill(arr,-1);
        }
        int ans = getPalindromicSubseq(s,0,m-1,dp);
        return ans;
    }
    
    int getPalindromicSubseq(String s,int i,int j,int[][] dp){
        if(i==j){
            return dp[i][j]=1;
        }
        if(j<i){
            return dp[i][j]=0;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j]=getPalindromicSubseq(s,i+1,j-1,dp)+2;
        }
        else{
            return dp[i][j]=Math.max(
                getPalindromicSubseq(s,i+1,j,dp),
                getPalindromicSubseq(s,i,j-1,dp)
            );
        }
    }
}