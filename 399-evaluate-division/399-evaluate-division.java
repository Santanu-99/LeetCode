class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        parent = new HashMap<>();
        mul = new HashMap<>();
        
        for(int i=0;i<equations.size();i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            
            addDSU(u);
            addDSU(v);
            
        }
        
        
        // union
        int i=0;
        for(List<String> eqn: equations){
            
            String l0 = find(eqn.get(0));
            String l1 = find(eqn.get(1));
            
            double m0 = mul.get(eqn.get(0));
            double m1 = mul.get(eqn.get(1));
            
            mul.put(l0, m1 * values[i] / m0);
            parent.put(l0 , l1);
            i++;


        }
        
        
        // processing query
        double[] ans = new double[queries.size()];
        
        i=0;
        for(List<String> query: queries){
            if(parent.containsKey(query.get(0)) == false || parent.containsKey(query.get(1)) == false){
                ans[i] = -1;
                i++;
                continue;
            }
            
            String l0 = find(query.get(0));
            String l1 = find(query.get(1));
            
            if(l0.equals(l1)){
                double m0 = mul.get(query.get(0));
                double m1 = mul.get(query.get(1));
                
                ans[i] = m0 / m1;
            }
            else{
                ans[i] = -1;
            }
            
            i++;
        }
        
        return ans;
    }
    
    HashMap<String , String> parent;
    HashMap<String , Double> mul ;
    
    void addDSU(String x){
        if(!parent.containsKey(x)){
            parent.put(x, x);
            mul.put(x, 1.0);
        }
    }
    
    String find(String x){
        if(x.equals(parent.get(x))){
            return x;
        }
        else{
            String cp = parent.get(x);
            String fp = find(parent.get(x));
            
            mul.put(x, mul.get(x) * mul.get(cp));
            parent.put(x,fp);
            
            return fp;
        }
    }
}