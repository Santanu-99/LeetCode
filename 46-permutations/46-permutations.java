class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        
        boolean[] vis = new boolean[nums.length];
        ans = new ArrayList<>();
        solver(new ArrayList<>(),nums,vis,0);
        return ans;
    }
    
    void solver(ArrayList<Integer> perm, int[] nums , boolean[] vis,int count){
        if(count == nums.length){
            List<Integer> base = new ArrayList<>(perm);
            ans.add(base);
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i] = true;
                perm.add(nums[i]);
                solver(perm , nums , vis, count+1);
                perm.remove(perm.size()-1);
                vis[i] = false;
            }
        }
        
        
    }
    
}