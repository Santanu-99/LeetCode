class Solution {
    public void sortColors(int[] nums) {
        int lo=0;
        int i=0;
        int hi=nums.length-1;
        
        while(i<=hi){      
            if(nums[i]==1){
                i++;
            }
            else if(nums[i]==0){
                swap(nums,lo,i);
                i++;
                lo++;
            }
            else if(nums[i]==2){
                swap(nums,i,hi);
                hi--;
            }    
        }
       
    }
    
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}