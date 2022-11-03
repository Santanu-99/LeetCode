class Solution {
    int lcount=0;
    int si=0;
    public String longestPalindrome(String s) {
        int m=s.length();
        int[][] dp = new int[m][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-2);
        }
        getSubstring(s,0,m-1,dp);
        return s.substring(si,si+lcount);
    }
    
    int getSubstring(String s ,int i,int j,int[][] dp){
        
        // System.out.println(s+", "+i+", "+j);
        
        
        if(i==j){
            if(lcount<1){
                lcount=1;
                si=i;
            } 
            return dp[i][j]=1;
        }
        if(j<i){
            return dp[i][j]=0;
        }
        
        if(dp[i][j]!=-2) return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j)){
            int c = getSubstring(s,i+1,j-1,dp);
            getSubstring(s,i+1,j,dp);
            getSubstring(s,i,j-1,dp);
            
            if(c==-1) return dp[i][j]=-1;
            else if(c+2>lcount){
                lcount=c+2;
                si = i;
            }
            return dp[i][j]=c+2;
        }
        else{
            
            getSubstring(s,i+1,j,dp);
            getSubstring(s,i,j-1,dp);
            return dp[i][j]=-1;
            
        }
    }
}