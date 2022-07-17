class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        
        int ans[] = new int[nums.length];
        int idx = ans.length-1;

        while(i<=j){
            if(Math.abs(nums[i]) <= Math.abs(nums[j])){
                ans[idx] =  nums[j] * nums[j];
                j--;
            }
            else{
                ans[idx] = nums[i] * nums[i];
                i++;
            }
            
            idx--;
        }
        
        return ans;
    }
}