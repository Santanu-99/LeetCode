class Solution {
    
    class Pair{
        int r , c;
        Pair(){}
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        
        Queue<Pair> qu = new LinkedList<>();
        for(int[] ar : dist){
            Arrays.fill(ar,-1);        
        }
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
            }
        }
        
        
        int lvl = 0;
        while(qu.size()>0){
            int tempSize = qu.size();
            lvl++;

            while(tempSize-- > 0){
                Pair rem = qu.remove();
                int r = rem.r;
                int c = rem.c;     
                
                for(int d=0;d<dir.length;d++){
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    if(0<=nr && 0<=nc && nr<dist.length && nc < dist[0].length && dist[nr][nc] == -1 ){                                   dist[nr][nc] = lvl;
                        qu.add(new Pair(nr,nc));
                    }
                }
            }
        }
        
        return dist;
    }
}