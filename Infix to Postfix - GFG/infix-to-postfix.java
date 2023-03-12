//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        }
        else if(ch == '/' || ch == '*'){
            return 2;
        }
        else if(ch == '^'){
            return 3;
        }
        else if(ch == '('){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public static String infixToPostfix(String exp) {
        // Your code here
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<exp.length()){
            char ch = exp.charAt(i);
            if(ch=='+' || ch=='-' || ch=='/' || ch=='*' || ch == '^'){
                if(st.size()==0 || precedence(st.peek()) < precedence(ch)){
                    st.push(ch);
                    i++;
                }
                else{
                    sb.append(st.pop());
                }
            }
            else if(ch == '('){
                st.push('(');
                i++;
            }
            else if(ch == ')'){
                if(st.peek() != '('){
                    sb.append(st.pop());
                }
                else{
                    st.pop();
                    i++;
                }
            }
            else{
                sb.append(ch);
                i++;
            }
            
        }
        while(st.size() > 0){
            sb.append(st.pop());
        }
        
        return sb.toString();
        
    }
}