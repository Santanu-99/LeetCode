//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long count = mergeMod(arr,0,(int)N-1);
        
        // System.out.println(Arrays.toString(arr));
        return count;
    }
    
    static long mergeMod(long[] arr , int lo , int hi){
        if(lo == hi){
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        
        long count1 = mergeMod(arr , lo , mid);
        long count2 = mergeMod(arr , mid + 1 , hi);
        
        long count = mergeSorted(arr , lo , mid , hi);
        // System.out.println(lo+" - "+hi + " => " +count);
        long finalCount = count + count1 + count2;
        
        return finalCount;
    }
    
    static long mergeSorted(long[] arr , int lo , int mid , int hi){
        int n = hi - lo + 1;
        long[] temp = new long[n];
        
        int i = lo , j = mid+1 , k = 0 ;
        long count = 0;
        
        while(i <= mid && j <= hi){
            
            if(arr[i] <= arr[j]){
                // System.out.println(arr[i]+ " <= "+ arr[j]);
                count += j - (mid + 1);
                temp[k] = arr[i];
                i++;
            }
            else if(arr[i] > arr[j]){
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(i<=mid){
            temp[k] = arr[i];
            count += hi - mid ;
            i++; k++;
        }
        
        while(j <= hi){
            temp[k] = arr[j];
            j++; k++;
        }
        
        
        i = 0 ; j = lo;
        while(i<n){
            arr[j++] = temp[i++];
        }
        
        return count;
    }
}