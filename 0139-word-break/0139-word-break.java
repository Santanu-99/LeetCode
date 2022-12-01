class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String w : wordDict){
            set.add(w);
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        int ans = check(0,s,set,dp);
        return ans==1;
    }
    
    int check(int si,String s , HashSet<String> set, int[] dp){
        if(si == s.length()){
            return 1;
        }
        if(dp[si] != -1) return dp[si];
        int recAns = 0;
        for(int ei=si+1;ei<=s.length();ei++){
            String w = s.substring(si,ei);
            if(set.contains(w)){
                recAns = check(ei,s,set,dp);
                if(recAns == 1){
                    return dp[si]=1;
                }
            }
        }
        
        return dp[si]=recAns;
    }
    
}