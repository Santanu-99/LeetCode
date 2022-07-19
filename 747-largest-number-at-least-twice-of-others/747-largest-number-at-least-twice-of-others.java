class Solution {
    public int dominantIndex(int[] nums) {
        int idx = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[idx] < nums[i]){
                idx = i;
            }
        }
        
       
        for(int i=0;i<nums.length;i++){
            
            if(nums[i] == nums[idx]){
                continue;
            }
            
            
            if(nums[i]*2 <= nums[idx]){
                continue;
            }
            else{
                return -1;
            }
        }
        
        return idx;
    }
}