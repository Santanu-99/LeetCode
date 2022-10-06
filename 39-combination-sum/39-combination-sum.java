class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        solver(candidates , target , 0 , comb , ans);
        return ans;
    }
    
    void solver(int[] candidate , int target , int idx , List<Integer> comb , List<List<Integer>> ans){
        if(idx == candidate.length || target == 0){
            if(target == 0){
                List<Integer> baseAns = new ArrayList<>(comb);
                ans.add(baseAns);
            }
            return;
        }
        
        if(target - candidate[idx] >= 0){
            comb.add(candidate[idx]);
            solver(candidate , target - candidate[idx] , idx , comb , ans);
            comb.remove(comb.size()-1);
        }
        
        solver(candidate, target , idx+1 , comb , ans);
        
    }
}