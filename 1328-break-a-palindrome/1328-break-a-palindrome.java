class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        
        String ans = "";
        
        // to check if all containing characters are a or not
        boolean flag = false;
        
        for(int i=0; i<palindrome.length(); i++){
            if(palindrome.charAt(i) != 'a'){
                if( (palindrome.length()%2 == 0) || (palindrome.length()%2 == 1 && i != palindrome.length()/2)){
                    flag = true;
                    break;
                } 
            }
        }
        
        
        if(flag == true){
            //if all characters is not 'a'
            // then first character with ascii greater than 'a' will be replaced by 'a'
            for(int i=0; i<palindrome.length(); i++){
                if(palindrome.charAt(i) != 'a'){
                    if((palindrome.length()%2 == 0) || (palindrome.length()%2 == 1 && i != palindrome.length()/2)){
                        ans = palindrome.substring(0,i)+"a"+palindrome.substring(i+1);
                        break;
                    } 
                }
            }
        }
            
        else{
            // if all characters is a
            // then the last character will be replaced by 'b' to make it lexicographically smallest
            ans = palindrome.substring(0,palindrome.length()-1) + 'b';
        }
        
        
        return ans;
        
    }
}