class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        
        s = s.trim();
        int end = s.length();
        
        for(int start = s.length()-1; start >= 0; start--){
            
            if(s.charAt(start) == ' ' &&  start+1 == end){
                end = start;
                continue;
            }
            
            if(s.charAt(start) == ' '){
                ans.append(s.substring(start+1 , end));
                ans.append(' ');
                end = start;
            }
        }
        
        ans.append(s.substring(0,end));
        
        // System.out.println(ans.toString());
        
        return ans.toString();
    }
}