// { Driver Code Starts
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
            int[][] paths = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    paths[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.isPossible(paths);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isPossible(int[][] paths)
    {
        // Code here
        int oddCount = 0;
        
        for(int[] nbrs : paths){
            
            // calculating degree
            int degree = 0;
            for(int nbr : nbrs){
                if(nbr == 1){
                    degree++;
                }
            }
            
            // checking if there is any vertex with odd degree
            if(degree %2 != 0){
                oddCount++;
            }
        }
        
        // if there is no vertex with odd degree then there exists an euler circuit
        // which means starting and ending vertex will be same for atleast 1 path
        if(oddCount == 0){
            return 1;
        }
        // else euler circuit not exists
        else{
            return 0;
        }
    }
}