class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        String str = "aeiouAEIOU";
        char[] vowels = str.toCharArray();
        for(char vowel : vowels){
            set.add(vowel);
        }
        
        StringBuilder sb = new StringBuilder(s);
        
        int i=0;
        int j = s.length()-1;
        
        while(i<j){
            
            while(i<j && !set.contains(sb.charAt(i))){
                i++;
            }    
            while(i<j && !set.contains(sb.charAt(j))){
                j--;
            } 
            
            char chi = sb.charAt(i);
            char chj = sb.charAt(j);
            sb.setCharAt(i, chj);
            sb.setCharAt(j, chi);
            
            i++;
            j--;
            
        }
        
        
        return sb.toString();
        
    }
}