class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        int ans = climbStairsMemo(0,n,dp);
        return ans;        
    }
    
    public int climbStairsMemo(int s ,int e , int[] dp){
        
        
        if(s==e){
            return dp[s]=1;
        } 
        
        if(dp[s] != 0) return dp[s];
        
        int count = 0;
        for(int j=1;j<=2;j++){
            if(s+j<=e)
                count += climbStairsMemo(s+j , e , dp);
        }
        return dp[s]=count;
    
    }

}