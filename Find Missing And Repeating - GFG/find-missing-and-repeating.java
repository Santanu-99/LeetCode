//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        
        // calculating xor
        int xres = 0;
        for(int i=0;i<n;i++){
            xres = xres ^ arr[i];
        }
        for(int i=1;i<=n;i++){
            xres = xres ^ i;
        }
        
        // System.out.println(xres);
        // System.out.println(Integer.toBinaryString(xres));
        
        // finding out the first position of different bits
        int diffPos = 1;
        while(true){
            if((diffPos&xres) != 0){
                break;
            }
            diffPos = diffPos << 1;
        }
        // System.out.println(Integer.toBinaryString(diffPos));
        
        
        int x = 0; // set Bit
        int y = 0; // unset Bit
        
        // looping over array
        for(int i=0;i<n;i++){
            // setBit
            if((diffPos&arr[i]) != 0){
                x = x^arr[i];
            }
            // unsetBit
            else{
                y = y^arr[i];
            }
        }
        // looping over i = 1....n
        for(int i=1;i<=n;i++){
            // setBit
            if((diffPos&i) != 0){
                 x = x^i;
            }
            // unsetBit
            else{
                 y = y^i;
            }
        }
        
        
        // finding out which one is missing and repeating out of x and y
        boolean xFlag = false;
        for(int i =0;i<n;i++){
            if(arr[i] == x){
                xFlag = true;
                break;
            }
        }
        int[] ans = new int[2];
        if(xFlag){
            ans[0] = x;
            ans[1] = y;
        }
        else{
        
            ans[0] = y;
            ans[1] = x;
            
        }
        
        return ans;
    }
}