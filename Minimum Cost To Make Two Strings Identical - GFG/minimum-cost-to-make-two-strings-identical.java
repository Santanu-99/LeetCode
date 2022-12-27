//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String X = sc.next();
                    String Y = sc.next();
                    int costX = sc.nextInt();
                    int costY = sc.nextInt();
                    
                   
                    Solution ob = new Solution();
                    System.out.println(ob.findMinCost(X,Y,costX,costY));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int findMinCost(String X, String Y, int costX, int costY)
	{
		// Your code goes here
		int lx = X.length();
		int ly = Y.length();
		
		int[][] dp = new int[lx+1][ly+1];
		for(int ar[] : dp) Arrays.fill(ar,-1);
		int lcs = getLCS(lx,ly,X,Y,dp);
		
		int cx = (lx - lcs) * costX;
		int cy = (ly - lcs) * costY;
		
		int totCost = cx + cy;
		return totCost;
		
	}
	
	int getLCS(int x,int y,String s1,String s2,int[][] dp){
	    
	    if(x==0 || y==0)
	        return dp[x][y]=0;
	    
	    
	    if(dp[x][y]!=-1) return dp[x][y];
	    
	    
	    int len = 0;
	    if(s1.charAt(x-1) == s2.charAt(y-1)){
	        len = getLCS(x-1,y-1,s1,s2,dp)+1;
	    }
	    else{
	        int up = getLCS(x-1,y,s1,s2,dp);
	        int down = getLCS(x,y-1,s1,s2,dp);
	        len = Math.max(up,down);
	    }
	    return dp[x][y]=len;
	}
}
