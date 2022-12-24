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
        long[] dp = new long[n+1];
        // for(long[] arr:dp)
        //     Arrays.fill(arr, -1);
        
        
        // Add your code here.
        int score[] = new int[]{3,5,10};
        long count  = count_tabu(n,2,score,dp);
        
        return count;
    }
    
    long count_tabu(int N,int idx , int[] score ,long[] dp){
        
        dp[0] = 1;
        for(int i=0;i<score.length;i++){
            for(int n=0;n<=N;n++){
                if((n-score[i])>=0){
                    dp[n] += dp[n-score[i]];
                }
            }
        }
        
        return dp[N];
    }
}