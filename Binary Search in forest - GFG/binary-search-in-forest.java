//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            
            int tree[]= new int[n];
            for(int i=0; i<n; i++)
                tree[i] = in.nextInt();
            int k = in.nextInt();
            
            Solution x = new Solution();
            System.out.println( x.find_height(tree,n,k) );
        }
	}
}
// } Driver Code Ends


class Solution
{
    static int find_height(int tree[], int n, int k)
    {
        Arrays.sort(tree);
        int lo=0,hi=tree[n-1];
        
        
        while(lo<=hi){
            int h = lo+(hi-lo)/2;
            int sum = 0;
            for(int i=0;i<tree.length;i++){
                if(tree[i] > h){ 
                    sum += tree[i] - h;
                }
            }
            if(sum == k){
                return h;
            }
            else if(sum < k){
                hi=h-1;
            }
            else{
                lo=h+1;
            }
        }
        
        return -1;
    }
}