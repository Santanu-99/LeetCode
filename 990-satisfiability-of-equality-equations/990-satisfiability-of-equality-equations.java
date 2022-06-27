class Solution {
    // DSU
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        // processing "==" first (By creating DSU)
        for(int i=0;i<equations.length;i++){      
            if(equations[i].charAt(1) == '='){
                int ch1 = equations[i].charAt(0) - 'a';
                int ch2 = equations[i].charAt(3) - 'a';

                int ch1l = find(ch1);
                int ch2l = find(ch2);

                if(ch1l != ch2l){
                    union(ch1l , ch2l);
                }
            }   
        } 
        
        // processing "!=" by verifying it using existing DSU
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1) == '!'){
                int ch1 = equations[i].charAt(0) - 'a';
                int ch2 = equations[i].charAt(3) - 'a';

                int ch1l = find(ch1);
                int ch2l = find(ch2);

                if(ch1l == ch2l){
                    return false;
                }
            }

        }
        return true;
    }
    
    // find() of DSU
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    // union() of DSU
    public void union(int s1l , int s2l){
        if(rank[s1l] < rank[s2l]){
            parent[s1l] = s2l;
        }
        else if(rank[s1l] > rank[s2l]){
            parent[s2l] = s1l;
        }
        else{
            parent[s1l] = s2l;
            rank[s1l]++;
        }
    }
}