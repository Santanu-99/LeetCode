class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int[] lpre = new int[nums.length];
        int[] rpre = new int[nums.length];
        
        lpre[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            lpre[i] = nums[i] + lpre[i-1];
        }
        
        rpre[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            rpre[i] = nums[i] + rpre[i+1];
        }
        
        int ans = -1;
        
        
        if(rpre[1] == 0){
            ans = 0;   
        } 
        else{
            for(int i=1;i<nums.length-1;i++){
                if(lpre[i-1] == rpre[i+1]){
                    ans = i;
                    break;
                }
            }
        }
        
        if(ans == -1 && lpre[nums.length-2]==0){
            ans = nums.length-1;
        }
        
            
        
        return ans;
    }
}