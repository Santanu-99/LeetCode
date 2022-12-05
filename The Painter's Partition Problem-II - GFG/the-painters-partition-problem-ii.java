//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long max = Long.MIN_VALUE;
        long sum = 0;
        for(long ele : arr){
            sum += ele;
            if(max < ele){
                max = ele;
            }
        }
        
        long ans = Long.MAX_VALUE;
        long lo = max;
        long hi = sum;
        
        boolean flag = false;
        while(lo<=hi){
            long part = 0;
            long maxPartSize=lo+(hi-lo)/2;
            int npart = 0;
        
            for(int i=0;i<arr.length;i++){
                part = part + arr[i];
                if(part > maxPartSize){
                    npart++;
                    part = arr[i];
                }
            }
            // System.out.println("nPart: "+npart+" PartSize: "+maxPartSize);
            if(npart == k-1){
                ans = maxPartSize;
                hi = maxPartSize-1;
                flag = true;
            }
            else if(npart < k-1){
                hi = maxPartSize-1;
                if(flag == false){
                    ans = maxPartSize;
                }
            }
            else{
                lo = maxPartSize +1;
            }
            
        }
        
        return ans;
    }
}


