//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        int[] lrdp = new int[n];
        lis_lr(nums,lrdp);
        int[] rldp = new int[n];
        lis_rl(nums,rldp);
        
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                ans = Math.max(ans,rldp[i]);
            }
            else if(i == nums.length-1){
                ans = Math.max(ans,lrdp[i]);
            }
            else{
                int l = lrdp[i] + rldp[i] - 1;
                ans = Math.max(ans,l);
            }
            
        }
        
        return ans;
    }
    
    int lis_lr(int[] nums ,int[] dp){
        int n = nums.length;
        for(int ei = 0;ei<n;ei++){
            int maxL = 0;
            for(int j=0; j<ei ;j ++){
                if(nums[j] < nums[ei]){
                    maxL = Math.max(maxL , dp[j]);
                }
            }
            dp[ei] = maxL+1;
        }
        
        int ans = 0;
        for(int l : dp){
            ans = Math.max(ans , l);
        }
        return ans;
    }
    
    int lis_rl(int[] nums, int[] dp){
        int n = nums.length;
        for(int ei = n-1;ei>=0;ei--){
            int maxL = 0;
            for(int j=n-1; j>ei ;j --){
                if(nums[j] < nums[ei]){
                    maxL = Math.max(maxL , dp[j]);
                }
            }
            dp[ei] = maxL+1;
        }
        
        int ans = 0;
        for(int l : dp){
            ans = Math.max(ans , l);
        }
        return ans;
        
    }
    
}