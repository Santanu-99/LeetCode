//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        
        // int ans = calcLcs(x,y,s1,s2);
        int[][] dp = new int[x+1][y+1];
        for(int[] ar: dp){
            Arrays.fill(ar,-1);
        }
        int ans = calcLcs_memo(x,y,s1,s2,dp);
        return ans;
    }
    
    static int calcLcs_memo(int x,int y,String s1,String s2,int[][] dp){
        
        if(x==0 || y==0){
            return dp[x][y]=0;
        }
        
        
        if(dp[x][y]!=-1) return dp[x][y];
        
        int myAns = 0;
        if(s1.charAt(x-1)==s2.charAt(y-1)){
            myAns =calcLcs_memo(x-1,y-1,s1,s2,dp)+1;
        }
        else{
            int first =calcLcs_memo(x-1,y,s1,s2,dp);
            int second =calcLcs_memo(x,y-1,s1,s2,dp);
            myAns = Math.max(first,second);
        }
        
        return dp[x][y]=myAns;
    }
    
    static int calcLcs(int x,int y,String s1,String s2){
        
        if(x==0 || y==0){
            return 0;
        }
        
        
        int myAns = 0;
        if(s1.charAt(x-1)==s2.charAt(y-1)){
            myAns =calcLcs(x-1,y-1,s1,s2)+1;
        }
        else{
            int first =calcLcs(x-1,y,s1,s2);
            int second =calcLcs(x,y-1,s1,s2);
            myAns = Math.max(first,second);
        }
        
        return myAns;
    }
    
}