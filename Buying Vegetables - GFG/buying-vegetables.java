//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG implements Runnable{
    public void run()
    {
        //everything that needs to be written in main() function should be here in run() method
        
        //we use try in order to catch IOExceptions becuase of using BufferedReader Class
    	try {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(in.readLine());
	        while(t-- > 0) {
	            int N = Integer.parseInt(in.readLine());
	            int cost[][] = new int[N][3];
	            for(int i = 0;i < N;i++) {
	                String a[] = in.readLine().trim().split("\\s+");
	                for(int j = 0;j < 3;j++)
	                    cost[i][j] = Integer.parseInt(a[j]);
	            }
	            
	            Solution ob = new Solution();
	            System.out.println(ob.minCost(N, cost));
	        }
        }
    	catch(Exception e) {
    		System.out.println("IOException");
    	}
    }
    public static void main(String[] args) throws IOException{
        //here increasing the stack size to increase the recursion limit
        //here 1 << 26 will create the stack size to 64MB that should be enough for problems
		new Thread(null, new GFG(), "whatever", 1<<26).start();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minCost(int N, int cost[][]) {
        // code here
        // int ans = getMinCost(cost,N,-1);
        
        
        int[][] dp = new int[N+1][3];
        for(int[] ar : dp) Arrays.fill(ar,-1);
        
        int ans = getMinCost_memo(cost,N,-1,dp);
        
        return ans;
    }
    
    static int getMinCost_memo(int[][] cost ,int shop,int block,int[][] dp){
        if(shop == 0){
            return dp[shop][block] = 0;
        }
        
        
        
        int min = Integer.MAX_VALUE;
        for(int itm=0;itm<3;itm++){
            if(itm != block){
                int recCost;
                
                if(dp[shop][itm] != -1) {
                    recCost = dp[shop][itm];  
                }
                else{
                    recCost = getMinCost_memo(cost,shop-1,itm,dp)+ cost[shop-1][itm];
                    dp[shop][itm] = recCost;
                }
                min = Math.min(min , recCost) ;
            }
        }
        
        return min;
    }
    
    static int getMinCost(int[][] cost ,int shop,int block){
        if(shop == 0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for(int itm=0;itm<3;itm++){
            if(itm != block){
                int recCost = getMinCost(cost,shop-1,itm)+ cost[shop-1][itm];
                min = Math.min(min , recCost) ;
            }
        }
        
        return min;
    }
}