class Solution {
    public int kSimilarity(String initial, String target) {
        
        Queue<String> qu = new LinkedList<>();
        qu.add(initial);
        
        HashSet<String> vis = new HashSet<>();
        vis.add(initial);
        
        int lvl = 0;
        while(qu.size() > 0){
            int tempSize = qu.size();
            for(int i=0;i<tempSize;i++){
                // remove
                String rem = qu.remove();
                
                // work
                if(rem.equals(target)){
                    return lvl;
                }
                
                // mark and add
                int idx = -1;
                for(int j =0; j<target.length(); j++){
                    if(rem.charAt(j) != target.charAt(j)){
                        idx = j;
                        break;
                    }
                }
                
    
                char correctCh = target.charAt(idx);
                
                for(int j=idx+1; j<target.length(); j++){
                    char ch = rem.charAt(j);
                    if(ch == correctCh){
                        String newStr = swap(rem,idx,j);
                        if(!vis.contains(newStr)){
                            vis.add(newStr);
                            qu.add(newStr);
                        }
                    }
                }
            }
            lvl++;
        }
        
        return -1;
    }
    
    
    String swap(String str , int i , int j){
        
        StringBuilder sb = new StringBuilder(str);
        char chi = str.charAt(i);
        char chj = str.charAt(j);
        
        sb.setCharAt(i , chj);
        sb.setCharAt(j , chi);
        
        return sb.toString();
        
        
    }
}