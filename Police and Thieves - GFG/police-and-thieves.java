//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
        // Code here
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
    
        
        for(int i=0;i<n;i++){
            if(arr[i] == 'P'){
                p.add(i);
            }
            else{
                t.add(i);
            }
        }
        
        
        
        int i=0,j=0;
        int count=0;
        while(i<p.size() && j<t.size()){
            int diff = Math.abs(p.get(i) - t.get(j));
            if(diff<=k){
                count++;
                i++;
                j++;
            }
            else{
                if(p.get(i) < t.get(j)){
                    i++;
                }
                else{
                   j++; 
                }
            }
        }
        
        return count;
	} 
} 



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends