//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.rremove(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String rremove(String s) {
        // code here
        
        
        String res = delete(s);
        while(res.length() != s.length()){
            s = res;
            res = delete(s);
            
        }
        
        return res;    
    }
    String delete( String s){
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int i=0;
        while(i < n){
            if(i<n-1){
                char ch1 = s.charAt(i);
                int j=i+1;
                char ch2 = s.charAt(j);
                if(ch1 == ch2){
                    while(j<s.length() && ch1 == s.charAt(j)){
                        j++;
                    }
                    
                    i = j;
                }
                else{
                    res.append(ch1);
                    i++;
                }
            }
            else{
                res.append(s.charAt(i));
                i++;
            }
        }
        
        return res.toString();
        
    } 
}