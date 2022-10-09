

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
        
        for(int i = idx; i<candidate.length ; i++){
            if(target - candidate[idx] >= 0){
                
                // prev and curr check to avoid duplicate calls
                if( (i == idx) || (candidate[i-1] != candidate[i]) ){
                    comb.add(candidate[i]);
                    solver(candidate , target - candidate[i] , i+1 , comb , ans);
                    comb.remove(comb.size()-1);    
                }
                
            }
        }

        
    }
}