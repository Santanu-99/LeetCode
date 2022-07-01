class Solution {
    
    HashMap<String,String> parent;
    HashMap<String,Integer> rank;
    
    String find(String x){
        if(parent.get(x).equals(x)){
            return x;
        }
        else{
            String p = find(parent.get(x));
            parent.put(x,p);
            return p;
        }
    }
    
    void union(String x , String y){
        if(rank.get(x) < rank.get(y)){
            parent.put(x,y);
        }
        else if(rank.get(x) > rank.get(y)){
            parent.put(y,x);
        }
        else{
            parent.put(x,y);
            rank.put(y,rank.get(y)+1);
        }
    }
    
    boolean areSimilar(String s1 , String s2){
        int diff = 0;
        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 != ch2){
                diff++;
            }
        }
        
        if(diff == 2){
            return true;
        }
        return false;
    }
    
    public int numSimilarGroups(String[] strs) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        
        for(String s : strs){
            parent.put(s,s);
            rank.put(s,0);
        }
        
        for(int i=0;i<strs.length;i++){
            String s1 = strs[i];
            
            for(int j=i+1;j<strs.length;j++){
                String s2 = strs[j];
                
                if(areSimilar(s1,s2)){
                    String s1l = find(s1);
                    String s2l = find(s2);
                    
                    if(!s1l.equals(s2l)){
                        union(s1l,s2l);
                    }
                }
            }
        }
        
        int count=0;
        for(String key: parent.keySet()){
            if(parent.get(key).equals(key)){
                count++;
            }
        }
        return count;
    }
}