class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        // int ans = climbStairsMemo(0,n,dp);
        int ans = climbStairsTabulation(0,n,dp);
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
    
    public int climbStairsTabulation(int S ,int E , int[] dp){
        
        for(int s=E;s >= S;s--){
            if(s==E){
                dp[s]=1;
                continue;
            } 

            if(dp[s] != 0) return dp[s];

            int count = 0;
            for(int j=1;j<=2;j++){
                if(s+j<=E)
                    count += dp[s+j]; //climbStairsMemo(s+j , e , dp);
            }
            dp[s]=count;
        }
        
        return dp[S];
    
    }

}