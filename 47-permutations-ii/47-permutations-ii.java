class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        List<Integer> perm = new ArrayList<>();
        
        solver(nums , vis,0 , perm);
        return ans;
    }
    
    void solver( int[] nums , boolean[] vis, int count , List<Integer> perm ){
        if(count == nums.length){
            List<Integer> base = new ArrayList<>(perm);
            ans.add(base);
            return;
        }
        
        int prev = -1;
        for(int i = 0; i<nums.length;i++){
            if( (prev == -1 && vis[i] == false) || (vis[i]==false && prev != -1 && nums[prev] != nums[i])){
                vis[i] = true;
                perm.add(nums[i]);
                solver(nums,vis,count+1,perm);
                perm.remove(perm.size()-1);
                vis[i] = false;
                prev = i;
            }  
        }
    }
}