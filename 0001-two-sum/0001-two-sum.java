class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        boolean flag = false;
        for(int i=0;i<nums.length && !flag ;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target == (nums[i] + nums[j])){
                    ans[0] = i;
                    ans[1] = j;
                    flag = true;
                    break;
                }
            }
        }
        
        return ans;
    }
}