

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
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
            solver(candidate , target - candidate[idx] , idx+1 , comb , ans);
            comb.remove(comb.size()-1);
        }
        int prev = idx;
        int curr = idx + 1;
        while(curr < candidate.length && candidate[prev] == candidate[curr]){
            prev = curr;
            curr = curr+1;
        }
        solver(candidate, target , curr , comb , ans);
        
    }
}