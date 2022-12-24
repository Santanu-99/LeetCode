//{ Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            
            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        long[][] dp = new long[3][n+1];
        for(long[] arr:dp)
            Arrays.fill(arr, -1);
        
        // Add your code here.
        int score[] = new int[]{3,5,10};
        long count  = count_memo(n,2,score,dp);
        
        return count;
    }
    
    long count_memo(int n,int idx , int[] score ,long[][] dp){
        
        if( n<0 || idx < 0){
            return 0;
        }
        else if(n==0){
            return dp[idx][0] = 1;
        }
        
        if(dp[idx][n]!=-1) return dp[idx][n];
        
        long myAns = count_memo(n-score[idx],idx,score,dp);
        myAns += count_memo(n,idx-1,score,dp);
        
        return dp[idx][n]=myAns;
    }
}