//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
import java.math.BigInteger;

class GFG
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t>0)
		{
		    String S[] = br.readLine().split(" ");
            
            int a = Integer.parseInt(S[0]);
            int b = Integer.parseInt(S[1]);
			Solution obj = new Solution();
			System.out.println(obj.sum(a,b));
            t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int sum(int a , int b)
    {
        //code here
        int sum = 0;
        int carry = 0;
        
        int bit = 1;
        for(int i = 0;i<32;i++){
            
            int abit = (a & bit) == 0 ? 0 : 1;
            int bbit = (b & bit) == 0 ? 0 : 1;
            
            int bitSum = abit + bbit + carry;
            if(bitSum == 0){
                carry = 0;
            }
            if(bitSum == 1){
                sum = sum ^ bit;
                carry = 0;
            }
            else if(bitSum == 2){
                carry = 1;
            }
            else if(bitSum == 3){
                sum = sum ^ bit;
                carry = 1;
            }
            bit = bit<<1;
        }
        return sum;
    }
}