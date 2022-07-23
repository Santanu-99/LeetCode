class Solution {
    public int maximumSwap(int num) {
        // converting number into an array of digits
        char[] digits = (num+"").toCharArray();
        int[] nums = new int[digits.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = digits[i] - '0';
        }
        
        // creating an array which stores the greatest element on right
        int[] right = new int[nums.length];
        for(int i=nums.length-1; i>=0;i--){
            if(i==nums.length - 1){
                right[i] = -1;
            }
            else if(i == nums.length - 2){
                right[i] = i+1;
            }
            else{
                if(nums[i+1] > nums[right[i+1]]){
                    right[i] = i+1;
                } 
                else{
                    right[i] = right[i+1];
                }
            }
        }
        
        
        // scanning from right if we found any greatest number on right greater than curr number the we perfrom a swap
        for(int i=0;i<nums.length-1 ; i++){
            if(nums[right[i]] > nums[i]){
                int temp = nums[i];
                nums[i] = nums[right[i]];
                nums[right[i]] = temp;
                
                break;
            }
        }
        
        int ans = 0;
        int y=1;
        for(int i=nums.length-1;i>=0;i--){
            ans= ans + y*nums[i];
            y= y*10;
        }
        
        return ans;
    }
}