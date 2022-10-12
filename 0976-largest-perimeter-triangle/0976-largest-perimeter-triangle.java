class Solution {
    public int largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        for(int i=nums.length-3; i>=0;i--){
            if(isTriangle(nums,i, i+2)){
                return getPerimeter(nums,i,i+2);
            }    
        }
        
        return 0;
        
    }
    
    boolean isTriangle(int[] nums , int start , int end){
        boolean flag = true;
        
        for(int i=start; i<=end ;i++){
            int sum = 0;
            for(int j=start; j<=end ;j++){
                if(i  != j){
                    sum += nums[j];
                }
            }
            if(sum <= nums[i]){
                return false;
            }
        }
        
        return true;
    }
    
    int getPerimeter(int[] nums , int start , int end){
        int perimeter = 0;
        for(int i = start ; i<=end; i++){
            perimeter += nums[i];
        }
        
        return perimeter;
    }
    
    
}