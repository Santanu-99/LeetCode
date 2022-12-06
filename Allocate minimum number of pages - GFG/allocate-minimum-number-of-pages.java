//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(N < M){
            return -1;
        }
        
        //Your code here
        long max = Long.MIN_VALUE;
        long sum = 0l;
        for(int ele : A){
            if(ele > max){
                max = ele;
            }
            sum += ele;
        }
        
        long lo = max;
        long hi = sum;
        
        while(lo < hi){
            long maxPageSize = lo + (hi - lo) / 2;
            // calculate number of students req. to finish all the pages
            int nStudent = 1;
            long pageSize = 0;
            for(int i=0;i<A.length;i++){
                pageSize = A[i] + pageSize;
                if(maxPageSize < pageSize){
                    pageSize = A[i];
                    nStudent++;
                }
            }
            
            // adjusting hi and lo accordingly
            if(nStudent > M){
                lo = maxPageSize + 1;
            }
            else{
                hi = maxPageSize;
                
            }
        }
        
        return (int)lo;
    }
};