//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        int mod = (int)1e9 + 7;
        long C[] = new long[r+1];
        C[0] = 1;// representing 0C0 = 1
        for(int i=1;i<n;i++){
            for(int col=r;col>=1;col--){
                C[col] = (C[col] + C[col-1])%mod;
            }
        }
        int ans =(int) ((C[r] + C[r-1])%mod);
        return ans;
    }
}