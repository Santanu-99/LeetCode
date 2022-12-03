class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int sum = 0;
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) < diff){
                    diff = Math.abs(target - sum);
                    ans = sum;
                }

                if(sum>target){
                    k--;
                }
                else{
                    j++;
                }
            }
            
        }
        
        return ans;
    }
}