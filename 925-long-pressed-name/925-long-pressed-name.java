class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i,j;
        i = j = 0;
        
        while(i < name.length() && j < typed.length()){
            char n = name.charAt(i);
            char t = typed.charAt(j);
            
            if(n == t){
                i++;
                j++;
            }
            else{
                if( 0 < i && name.charAt(i-1) == typed.charAt(j)){
                    j++;
                }else{
                    return false;
                }
            }
        }
        
        if(i < name.length()){
            return false;
        }
        else if(j < typed.length()){
            char ch = name.charAt(name.length()-1);
            while(j < typed.length()){
                if(ch != typed.charAt(j)){
                    return false;
                }
                j++;

            }
        }
        
        return true;
    }
}