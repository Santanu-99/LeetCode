class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        // int count = getDistinct(m, n , s ,t);
        int count = getDistinct_memo(m, n , s ,t,dp);
        return count;
    }
    
    int getDistinct_memo(int m , int n , String s , String t,int[][] dp){
        if(n==0){
            return dp[m][n]=1;
        }
        if(m<n){
            return dp[m][n]=0;
        }
        
        if(dp[m][n] != -1) return dp[m][n];
       
        if(s.charAt(m-1) == t.charAt(n-1)){
            return dp[m][n]=getDistinct_memo(m-1,n,s,t,dp)+getDistinct_memo(m-1,n-1,s,t,dp);
        }
        else{
            return dp[m][n]=getDistinct_memo(m-1,n,s,t,dp);
        }
    }
}