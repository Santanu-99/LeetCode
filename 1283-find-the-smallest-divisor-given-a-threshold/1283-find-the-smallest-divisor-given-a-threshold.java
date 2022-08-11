class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        for(int num : nums){
            if(hi < num){
                hi = num;
            }
        }
        
        while(lo < hi){
            int div = (lo + hi) / 2;
            
            int thFound = 0;
            for(int num : nums){
                thFound += (int)Math.ceil(num*1.0 / div);
            }
            
            if(thFound <= threshold){
                hi = div;
            }
            else{
                lo = div + 1;
            }
        }
        
        return lo;
    }
}