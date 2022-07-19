class Solution {
    
    int[] parent,rank;
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }    
    
    void union(int xLead , int yLead){
        if(rank[xLead] > rank[yLead]){
            parent[yLead] = xLead;
        }
        else if(rank[xLead] < rank[yLead]){
            parent[xLead] = yLead;
        }
        else{
            parent[yLead] = xLead;
            rank[xLead]++;
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] charArr = s.toCharArray();
        
        parent = new int[charArr.length];
        rank = new int[charArr.length];
        
        for(int i = 0; i<parent.length ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(List<Integer> list : pairs){
            int x = list.get(0);
            int y = list.get(1);
            
            int xLead = find(x);
            int yLead = find(y);
            
            if(xLead != yLead){
                union(xLead , yLead);
            }

        }
        
        HashMap<Integer,PriorityQueue<Character>> hm = new HashMap<>();
        
        for(int i=0;i<charArr.length;i++){
            int iLead = find(i);
            if(hm.containsKey(iLead)){
                PriorityQueue<Character> pq = hm.get(iLead);
                pq.add(charArr[i]);
            }
            else{
                PriorityQueue<Character> newPQ = new PriorityQueue<>();
                newPQ.add(charArr[i]);
                hm.put(iLead , newPQ);
            }
        }
        
        
        char[] ans = new char[charArr.length];
        for(int i=0;i< ans.length ; i++){
            int iLead = find(i);
            PriorityQueue<Character> pq = hm.get(iLead);
            ans[i] = pq.remove();
        }
        
        return new String(ans);
    }
}