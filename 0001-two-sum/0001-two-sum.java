class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int ele : nums){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        
        int fEle,sEle;
        fEle=sEle=0;
        
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                if(nums[i] != target-nums[i] || hm.get(nums[i]) > 1){
                    fEle = nums[i];
                    sEle = target - nums[i];
                    break;
                }
            }
        }
        
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==fEle || nums[i] == sEle){
                ans[count] = i;
                count++;
            } 
        }
        
        return ans;
    }
}