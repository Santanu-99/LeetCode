class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> s2t = new HashMap<>();
        HashMap<Character,Character> t2s = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(s2t.containsKey(ch1) && t2s.containsKey(ch2)){
                char k = s2t.get(ch1);
                char l = t2s.get(ch2);
                if(k!=ch2 || l!=ch1){
                    return false;
                }
            }
            else if(s2t.containsKey(ch1)){
                char k = s2t.get(ch1);
                if(ch2 != k){
                    return false;
                }
            }
            else if(t2s.containsKey(ch2)){
                char l = t2s.get(ch2);
                if(ch1 != l){
                    return false;
                }
            }
            else{
                s2t.put(ch1,ch2);
                t2s.put(ch2,ch1);
            }
            
        }
        
        return true;
    }
}