class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int count = 0;
        
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            
            int c = hm.getOrDefault(rem,0);
            
            count += c;
            hm.put(rem,c+1);
        }
        
        return count;
    }
}