class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pdp = new boolean[n][n];
        for(int gap = 0 ; gap<n ; gap++){
            for(int i=0,j=gap ; j<n ; i++,j++){
                if(gap == 0){
                    pdp[i][j] = true;
                }
                else if(gap==1 && s.charAt(i) == s.charAt(j)){
                     pdp[i][j] = true;
                }
                else if(pdp[i+1][j-1]==true && s.charAt(i) == s.charAt(j)){
                    pdp[i][j] = true;
                }
            }
        }
        
        int[] dp = new int[n];
        int ans = getPartition(0,s,dp,pdp);
        return ans-1;
    }
    
    public int getPartition(int si,String s,int[] dp ,boolean[][] pdp){
        if(si == s.length()){
            return 0;
        }
        
        if(dp[si] != 0) return dp[si];
        
        int minPart = Integer.MAX_VALUE;
        for(int ei=si;ei<s.length();ei++){
            if(pdp[si][ei]){
                int npart = getPartition(ei+1,s,dp,pdp);
                npart = npart < Integer.MAX_VALUE ? npart+1 : Integer.MAX_VALUE;
                if(npart<minPart){
                    minPart = npart;
                }
            }    
        }
        
        dp[si] = minPart;
        return dp[si];
    }
    
}