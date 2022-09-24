class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        solver(new ArrayList<>(),nums);
        return ans;
    }
    
    void solver(ArrayList<Integer> perm, int[] nums){
        if(nums.length == 0){
            List<Integer> base = new ArrayList<>(perm);
            ans.add(base);
            return;
        }
        
        int[] n = new int[nums.length-1];
        for(int ele : nums){
            int idx = 0;
            for(int i = 0;i<nums.length;i++){
                if(nums[i] != ele){
                    n[idx++]=nums[i]; 
                }
            }
            perm.add(ele);
            solver(perm,n);
            perm.remove(perm.size()-1);
        }
    }
    
}