//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int nums[], int n)
    {
        int[] sum_dp_lr = new int[n];
	    for(int ei = 0;ei<n;ei++){
	        int max = 0;
	        for(int j = 0;j<ei;j++){
	            if(nums[j] < nums[ei]){
	                max = Math.max(sum_dp_lr[j],max);
	            }
	        }
	        max = max + nums[ei];
	        sum_dp_lr[ei] = max;
	    }
	    
	    int[] sum_dp_rl = new int[n];
	    for(int ei = n-1;ei>=0;ei--){
	        int max = 0;
	        for(int j = n-1;j>ei;j--){
	            if(nums[j] < nums[ei]){
	                max = Math.max(sum_dp_rl[j],max);
	            }
	        }
	        max = max + nums[ei];
	        sum_dp_rl[ei] = max;
	    }
	    
	    int ans = 0;
	    for(int i = 0;i<nums.length;i++){
	        if(i == 0){
                ans = Math.max(ans,sum_dp_rl[i]);
            }
            else if(i == nums.length-1){
                ans = Math.max(ans,sum_dp_lr[i]);
            }
            else{
                int sum = sum_dp_lr[i] + sum_dp_rl[i] - nums[i];
                ans = Math.max(ans,sum);
            }
	    }
	    return ans;  
    }
}