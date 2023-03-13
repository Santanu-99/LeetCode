//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	//doesn't knows anyone
    	boolean[] row = new boolean[n];
    	// known by everyone
    	boolean[] col = new boolean[n];
    	
    	for(int i=0;i<n ;i++){
    	    int oneCount = 0;
    	    for(int j=0;j<n;j++){
    	        if(M[i][j] == 1) oneCount++;
    	    }
    	    if(oneCount == 0) row[i] = true;
    	}
    	for(int j=0;j<n ;j++){
    	    int oneCount = 0;
    	    for(int i=0;i<n;i++){
    	        if(M[i][j] == 1) oneCount++;
    	    }
    	    if(oneCount == (n-1)) col[j] = true;
    	}
    	
    	
    	for(int i=0;i<n;i++){
    	    if(row[i] && col[i]){
    	        return i;
    	    }
    	}
    	
    	return -1;
    }
}