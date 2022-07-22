class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        //using two pointer approach
        int i,j;
        i = j = 0;
        while(i<nums.length){
            // if even is found in i then increase then swap and increase both i and j
            if(nums[i] % 2 == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            // if odd found then just increse i
            else{
                i++;
            }
            
        }
        
        return nums;
    }
}