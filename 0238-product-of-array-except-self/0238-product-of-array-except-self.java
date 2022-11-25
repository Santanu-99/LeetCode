class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suff = new int[nums.length];
        
        int mul = 1;
        for(int i=0;i<nums.length;i++){
            mul = mul * nums[i];
            pre[i] = mul;
        }
        mul = 1;
        for(int i=nums.length-1;i>=0;i--){
            mul = mul * nums[i];
            suff[i] = mul;
        }
        
        
        int[] prod = new int[nums.length];
        prod[0] = suff[1];
        prod[nums.length-1] = pre[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            prod[i] = pre[i-1] * suff[i+1];
        }
        
        return prod;
    }
}