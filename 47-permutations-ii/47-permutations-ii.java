class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        List<Integer> perm = new ArrayList<>();
        
        solver(nums , vis , perm);
        return ans;
    }
    
    void solver( int[] nums , boolean[] vis , List<Integer> perm ){
        boolean flag = true;
        for(int i=0;i<vis.length;i++){
            if(vis[i] == false){
                flag = false;
                break;
            }
        }
        
        if(flag){
            List<Integer> base = new ArrayList<>(perm);
            ans.add(base);
            return;
        }
        
        int prev = -1;
        for(int i = 0; i<nums.length;i++){
            if( (prev == -1 && vis[i] == false) || (vis[i]==false && prev != -1 && nums[prev] != nums[i])){
                vis[i] = true;
                perm.add(nums[i]);
                solver(nums,vis,perm);
                perm.remove(perm.size()-1);
                vis[i] = false;
                prev = i;
            }  
        }
    }
}