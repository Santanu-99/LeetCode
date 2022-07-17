class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = (n+"").toCharArray();
        
        int idx1 = -1;
        for(int i = nums.length - 2 ; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx1 = i;
                break;
            }
        }
        
        // already greatest
        if(idx1 == -1){
            return -1;
        }
        
        
        
        int i = nums.length - 1;
        while(nums[idx1] >= nums[i]){    
            i--;
        }
        char temp = nums[idx1];
        nums[idx1] = nums[i];
        nums[i] = temp;
        
        System.out.println(new String(nums));
        // reversing the ascending order region on the right
        i = idx1+1;
        int j = nums.length - 1;
        while(i <= j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        
        String num = new String(nums);
        Long ans = Long.parseLong(num);
        
        if(ans > Integer.MAX_VALUE){
            return -1;
        }else{
            return ans.intValue();
        }
        
    }
}