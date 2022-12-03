class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int ele : nums){
            ts.add(ele);
        }
        
        int i=0;
        while(ts.size()>0){
            nums[i] = ts.pollFirst();
            i++;
        }
        
        return i;
    }
}