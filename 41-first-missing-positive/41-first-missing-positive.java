class Solution {
    
    void display(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+", ");
        }
        System.out.println();
    }
    
    public int firstMissingPositive(int[] nums) {
        
        // marking all -ve,0 and greater numbers by length+1
        // essentially obtaining an array of positive numbers in which we can easily identify numbers with in [1 -- num.length]
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length){
                nums[i] = nums.length+1;
            }
        }
        // display(nums);
        // marking all the numbers(n) in [ 1 - nums.length] present by making the number at index (n-1) negative
        for(int n: nums){
            n = Math.abs(n);
            if(1<=n && n<=nums.length){
                if(nums[n-1] > 0){
                    nums[n-1] = nums[n-1] * (-1);
                }
            }
        }
        
        // display(nums);
        
        // if nums[i] > 0 that means (i+1) number wasn't found hence (i+1) will be our smallest number
        for(int i=0; i<nums.length;i++){
            if(nums[i] > 0){
                return i+1 ;
            }
        }
        
        return nums.length+1;
    }
}