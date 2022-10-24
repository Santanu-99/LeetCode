class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        climbStairsMemo(0,cost.length,dp,cost);
        return Math.min(dp[0],dp[1]);  
    }
    
     public int climbStairsMemo(int s ,int e , int[] dp ,int[] cost){
        
        
        if(s==e){
            return dp[s]=0;
        } 
        
         if(dp[s] != 0) return dp[s];
             
        int minCost = Integer.MAX_VALUE;
        for(int j=1;j<=2;j++){
            if(s+j<=e){
                int c = climbStairsMemo(s+j , e , dp,cost);
                minCost = minCost > c ? c : minCost;
            }        
        }
        
        int actualCost = minCost + cost[s];
        return dp[s] = actualCost;
    
    }
}