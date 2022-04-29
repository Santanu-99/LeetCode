class Solution {
    
    public class Pair{
        int src,group;
        Pair(){}
        Pair(int src,int group){
            this.src = src;
            this.group = group;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<vis.length;i++){
            if(vis[i]==-1){
                Queue<Pair> qu = new LinkedList();
                qu.add(new Pair(i,0));

                while(qu.size()!=0){
                    Pair rem = qu.remove();
                    if(vis[rem.src] != -1){
                        if(vis[rem.src] == rem.group){
                            continue;
                        }else{
                            return false;
                        }
                    }

                    vis[rem.src] = rem.group;

                    for(int nbr : graph[rem.src]){
                        qu.add(new Pair(nbr,(rem.group+1)%2));
                    }
                }

            }
            
        }
        
        return true;
        
    }
}