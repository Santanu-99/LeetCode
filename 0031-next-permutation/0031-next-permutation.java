class Solution {
    public void nextPermutation(int[] nums) {
        int idx = nums.length-2;
        
        while(idx>=0 && nums[idx] >= nums[idx+1]){
            idx--;
        }
        
        if(idx == -1){
            reverse(nums,0,nums.length-1);
            return;
        }
        
        int rdx = nums.length-1;
        while(idx<rdx && nums[idx]>=nums[rdx]){
            rdx--;
        }
        int temp = nums[idx];
        nums[idx] = nums[rdx];
        nums[rdx] = temp;
        
        reverse(nums,idx+1,nums.length-1);
        
    }
    
    void reverse(int[] nums, int s ,int e){
        while(s<e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}