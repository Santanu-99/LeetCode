class Solution {
    
    public String crackSafe(int n, int k) {
        int passCount = (int)Math.pow(k,n);
        HashSet<String> vis = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append('0');
        }
        
        vis.add(sb.toString());
        String ans = getMinString(vis, sb , n , k , passCount);
        
        return ans;
    }
    
    public String getMinString(HashSet<String> vis , StringBuilder sb ,int n, int k, int passCount){
        if(vis.size() == passCount){
            return sb.toString();
        }
        
        for(int i = 0;i<k;i++){
            
            sb.append(i);
            String pass = sb.substring(sb.length() - n);
            
            if(!vis.contains(pass)){
                
                vis.add(pass);
                String ans = getMinString(vis,sb,n,k,passCount);
                
                if(ans != null){
                    return ans;
                }else{
                    vis.remove(pass);
                }
            }
            
            sb.deleteCharAt(sb.length()-1);
        }
        
        return null;
        
    }
}