//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	    int ans = 0;
	    boolean flag = false;
	    if(str.charAt(0) == '-'){
	        flag = true;
	        str = str.substring(1,str.length());
	    }
	    for(int i=0;i<str.length();i++){
	        char ch = str.charAt(i);
	        if('0'<=ch && ch <='9'){
	            int d = ch - '0';
	            ans = ans*10 + d;
	        }
	        else{
	            return -1;
	        }
	    }
	    if(flag){
	        ans = ans * (-1);
	    }
	    
	    
	    return ans;
    }
}
