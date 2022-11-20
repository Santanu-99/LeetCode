class Solution {
    public boolean isUgly(int n) {
        if(n==0){
            return false;
        }
        int temp = n;
        
        while(temp%2 == 0){
            temp = temp / 2;
        }
        // System.out.println(temp);
        
        while(temp %3 == 0){
            temp = temp / 3;
        }
        // System.out.println(temp);

        while(temp % 5 == 0){
            temp = temp / 5;
        }
        // System.out.println(temp);
        boolean ans =  temp == 1 ? true : false;
        return ans;
    }
}