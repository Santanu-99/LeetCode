class Solution {
    static class Pair{
        int val;
        int idx;
        Pair(){}
        Pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        Pair[] parr = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            parr[i] = new Pair(nums[i],i);
        }
        
        Arrays.sort(parr,(a,b)->{
            return a.val-b.val;
        });
        
        int l = 0;
        int r = parr.length-1;
        while(l<r){
            if(parr[l].val + parr[r].val == target){
                ans[0] = parr[l].idx;
                ans[1] = parr[r].idx;
                break;
            }
            else if(parr[l].val+parr[r].val<target){
                l++;
            }
            else{
                r--;
            }
        }
        
        return ans;
    }
}