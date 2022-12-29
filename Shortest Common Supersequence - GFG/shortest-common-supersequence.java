//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        
        int[][] dp = new int[m+1][n+1];
        for(int[] ar : dp)
            Arrays.fill(ar,-1);
        
        int lcs = getLcs(m,n,X,Y,dp);
        
        int ans = m + n - lcs;
        return ans;
    }
    
    static int getLcs(int m,int n,String x,String y,int[][] dp){
        if(m==0 || n==0){
            return dp[m][n] = 0;
        }
        
        if(dp[m][n] != -1) return dp[m][n];
        
        int len = 0;
        if(x.charAt(m-1) == y.charAt(n-1)){
            len = getLcs(m-1,n-1,x,y,dp)+1;
        }
        else{
            len = Math.max(getLcs(m-1,n,x,y,dp),getLcs(m,n-1,x,y,dp));
        }
        
        return dp[m][n]=len;
    }
}