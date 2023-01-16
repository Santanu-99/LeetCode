//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        // int ans = getMax(price , n);
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = getMax_memo(price , n,dp);
        return ans;
    }
    
    int getMax_memo(int price[] ,int n,int[] dp){
        if(n==0){
            return dp[n]=0;
        }
        
        if(dp[n] != -1) return dp[n];
        
        int max = 0;
        for(int i=1;i<=n;i++){
            int cost = getMax_memo(price , n-i ,dp) + price[i-1];
            max = Math.max(max , cost);
        }
        
        return dp[n]=max;
    }
    int getMax(int price[] ,int n){
        if(n==0){
            return 0;
        }
        
        int max = 0;
        for(int i=1;i<=n;i++){
            int cost = getMax(price , n-i) + price[i-1];
            max = Math.max(max , cost);
        }
        
        return max;
    }
}