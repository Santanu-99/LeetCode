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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int x = str1.length();
	    int y = str2.length();
	   // int ans = getMinOperations(x,y,str1,str2);
	   
	    int[][] dp = new int[x+1][y+1];
	    for(int[] ar : dp) Arrays.fill(ar,-1);
	    int ans = getMinOperations_memo(x,y,str1,str2,dp);
	    return ans;
	    
	} 
	
	int getMinOperations_memo(int x,int y,String str1,String str2,int[][] dp){
	    if(x==0){
	        // if str1 empty only insertionOP is needed
	        return dp[x][y]=y;
	    }
	    else if(y==0){
	        // if str2 empty only deletionOp is needed
	        return dp[x][y]=x;
	    }
	    
	    if(dp[x][y]!=-1) return dp[x][y];
	    
	    int minOp = Integer.MAX_VALUE;
	    if(str1.charAt(x-1) == str2.charAt(y-1)){
	        minOp = getMinOperations_memo(x-1,y-1,str1,str2,dp);
	    }
	    else{
	        int insert = getMinOperations_memo(x,y-1,str1,str2,dp)+1;
	        int delete = getMinOperations_memo(x-1,y,str1,str2,dp)+1;
	        minOp = Math.min(insert,delete);
	    }
	    
	    return dp[x][y]=minOp;
	}
	
	
	
	int getMinOperations(int x,int y,String str1,String str2){
	    if(x==0){
	        // if str1 empty only insertionOP is needed
	        return y;
	    }
	    else if(y==0){
	        // if str2 empty only deletionOp is needed
	        return x;
	    }
	    
	    
	    int minOp = Integer.MAX_VALUE;
	    if(str1.charAt(x-1) == str2.charAt(y-1)){
	        minOp = getMinOperations(x-1,y-1,str1,str2);
	    }
	    else{
	        int insert = getMinOperations(x,y-1,str1,str2)+1;
	        int delete = getMinOperations(x-1,y,str1,str2)+1;
	        minOp = Math.min(insert,delete);
	    }
	    
	    return minOp;
	}
	
	
}