//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        // int ans = maximizeSum(arr, n-1);
        
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = maximizeSumMemo(arr, n-1,dp);
        return ans;
    }
    
    int maximizeSumMemo(int[] arr , int n,int[] dp){
        
        if(n < 0){
            return 0; 
        }
        
        if(dp[n]!=-1) return dp[n];
        
        int inc = maximizeSumMemo(arr, n-2 ,dp) + arr[n];
        int exc = maximizeSumMemo(arr,n-1,dp);
        
        int myAns = Math.max(inc,exc);
        dp[n] = myAns;
        
        return myAns;
    }
    int maximizeSum(int[] arr , int n){
        
        if(n < 0){
            return 0; 
        }
        
        int inc = maximizeSum(arr, n-2) + arr[n];
        int exc = maximizeSum(arr,n-1);
        
        int myAns = Math.max(inc,exc);
        
        return myAns;
    }
}