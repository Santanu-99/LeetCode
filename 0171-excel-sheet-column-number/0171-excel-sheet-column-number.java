class Solution {
    public int titleToNumber(String columnTitle) {
        int mul = 1;
        int ans = 0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            char ch = columnTitle.charAt(i);
            int l = ch - 64;
            ans = mul * l + ans;
            mul = mul*26;
        }
        return ans;
    }
}