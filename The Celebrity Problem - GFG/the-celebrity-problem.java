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
    	Stack<Integer> st = new Stack<>();
        
        
        for(int i=0;i<n;i++){
            st.push(i);
        }
        
        for(int i=0;i<n-1;i++){
            int a = st.pop();
            int b = st.pop();
            if(M[a][b] == 0){
                st.push(a);
            }
            else{
                st.push(b);
            }
        }
        
        int p = st.pop();
        int count = 0;
        for(int i=0;i<n;i++){
            if(M[i][p] == 1){
                count++;
            }
            if(M[p][i] == 1){
                return -1;
            }
        }
        if(count < n-1){
            return -1;
        }
        
        
        return p;
    }
}