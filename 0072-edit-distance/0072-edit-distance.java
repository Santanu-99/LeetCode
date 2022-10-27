class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // int count = getMinChange(m,n,  word1 , word2);

        int dp[][] = new int[m+1][n+1];
        int count = getMinChangeMemo(m,n,  word1 , word2,dp);

        return count;
    }
    public int getMinChangeMemo(int m , int n , String word1,String word2,int[][] dp){
         
        if(n==0 && m==0){
            return dp[m][n]=0;
        }
        else if(m==0){
            return dp[m][n]=n;
        }
        else if(n==0){
            return dp[m][n]=m;
        }

        if(dp[m][n] != 0) return dp[m][n];
        
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return dp[m][n]=getMinChangeMemo(m-1,n-1,word1,word2,dp);
        }
        else{
            int insert = getMinChangeMemo(m,n-1,word1,word2,dp);
            int replace = getMinChangeMemo(m-1,n-1,word1,word2,dp);
            int delete = getMinChangeMemo(m-1,n,word1,word2,dp);

            return dp[m][n]=Math.min(insert, Math.min(replace , delete))+1;
        }

    }
    public int getMinChange(int m , int n , String word1,String word2){
        
        if(n==0 && m==0){
            return 0;
        }
        else if(m==0){
            return n;
        }
        else if(n==0){
            return m;
        }
        
        
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return getMinChange(m-1,n-1,word1,word2);
        }
        else{
            int insert = getMinChange(m,n-1,word1,word2);
            int replace = getMinChange(m-1,n-1,word1,word2);
            int delete = getMinChange(m-1,n,word1,word2);
            
            return Math.min(insert, Math.min(replace , delete))+1;
        }
        
         
    }
    

    
    
}