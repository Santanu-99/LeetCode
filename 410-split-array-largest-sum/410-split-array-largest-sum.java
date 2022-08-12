class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = -1;
        int hi = 0;
        for(int num : nums){
            lo = Math.max(num  , lo);
            hi += num;
        }
        
        while(lo < hi){
            int aps = (lo + hi)/2;
            int reqP = 1;
            int ps= 0;
            for(int num : nums){
                if((ps+num) <= aps){
                    ps += num;
                }
                else{
                    reqP++;
                    ps = num;
                }
            }
            
            if(reqP <= m){
                hi = aps;
            }
            else{
                lo = aps+1;
            }
        }
        
        return lo;
    }
}