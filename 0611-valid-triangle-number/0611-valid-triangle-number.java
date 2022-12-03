class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;       
        
        for(int i=nums.length-1; i>=2; i--){
            int j = i-1;
            int k = 0;

            while(k<j){
                if(nums[k]+nums[j]<=nums[i]){
                    k++;
                }
                else{
                    count += j-k;
                    j--;
                }
            }
        }
        
        
        return count;
    }
}