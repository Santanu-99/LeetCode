class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pFromRight = new int[nums.length];
        pFromRight[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            pFromRight[i] = pFromRight[i+1] * nums[i+1];
        }
        
        int pFromLeft = 1;
        int ans[] = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            ans[i] = pFromLeft * pFromRight[i];
            pFromLeft = pFromLeft * nums[i];
        }
        
        return ans;
    }
}