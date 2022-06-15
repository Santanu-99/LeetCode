class Solution {
    class Pair{
        int r ,c;
        Pair(){}
        Pair(int r , int c){
            this.r = r;
            this.c = c;
        }
    }
    
    
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public int maxDistance(int[][] grid) {
        Queue<Pair> qu = new LinkedList<>();
        
        int[][] dist = new int[grid.length][grid[0].length];
        
        for(int[] ar : dist){
            Arrays.fill(ar,-1);
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j] == 1){
                    qu.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
                    
            }
        }
        
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
                
//                 System.out.print(dist[i][j]+",");
                    
//             }
//             System.out.println();
//         }
        
        int lvl = 1;
        while(qu.size() > 0){
            int tempSize = qu.size();
            while(tempSize-- > 0){
                
                //remove
                Pair rem = qu.remove();
                int r = rem.r;
                int c = rem.c;
                
                for(int d=0;d<dir.length;d++){
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    if(0<=nr && 0<=nc && nr<dist.length && nc < dist[0].length && dist[nr][nc] == -1 ){                                 //work and mark
                        dist[nr][nc] = lvl;
                        //add
                        qu.add(new Pair(nr,nc));
                    }
                }
            }
            lvl++;
        }
        
        
        
        
        
        
        
        int max=-1;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j] == 0){
                    if(dist[i][j] > max){
                        max= dist[i][j];
                    }
                }
                    
            }
        }
        
        return max;
        
    }
}