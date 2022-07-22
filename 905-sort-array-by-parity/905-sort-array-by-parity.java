class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            //skip evens at beginning
            while( i<nums.length && nums[i] % 2 == 0 ){
                i++;
            }
            //skip odd at the end
            while( j>=0 && nums[j] % 2 != 0){
                j--;
            }
            
            //if i and j still holds the condition
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                //move on to the next positions
                i++;
                j--;
            }
            
        }
        
        return nums;
    }
}