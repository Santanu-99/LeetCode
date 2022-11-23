class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        int temp = columnNumber;
        while(temp >0){
            int c = temp % 26;
            char ch;
            if (c==0) ch = 'Z';
            else ch = (char)(64+c);
            str.append(ch);
            if(c==0){
                temp = temp / 26 - 1;
            }
            else{
                temp = temp / 26;
            }
            
        }
        
        return str.reverse().toString();
    }
}