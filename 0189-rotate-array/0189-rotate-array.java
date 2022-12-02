class Solution {
    public void rotate(int[] nums, int k) {
        if(k>=nums.length) k = k%nums.length;
        int b = nums.length - k - 1;
        reverse(nums,0,b);
        reverse(nums,b+1,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    void reverse(int[] nums, int s , int e){
        int i=s,j=e;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}