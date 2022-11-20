class Solution {
    public boolean isUgly(int n) {
        if(n==0){
            return false;
        }
        
        int[] facts = {2,3,5};
        int temp = n;
        
        for(int i=0;i<facts.length;i++){
            int fact = facts[i];
            while(temp%fact == 0){
                temp = temp / fact;
            }
        }
        
        boolean ans =  temp == 1 ? true : false;
        return ans;
    }
}