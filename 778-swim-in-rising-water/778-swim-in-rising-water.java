class Solution {
    
    class Pair{
        int r,c,time;
        Pair(){}
        Pair(int r,int c,int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    
    
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.time - b.time;
        });
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        pq.add(new Pair(0,0,grid[0][0]));
        
        while(pq.size() > 0){
            
            // remove
            Pair rem = pq.remove();
            int r = rem.r;
            int c = rem.c;
            int time = rem.time;
            
            // mark
            if(visited[r][c]){
                continue;
            }
            visited[r][c] = true;
            
            // work
            if(r == grid.length-1 && c == grid[0].length-1){
                return time;
            }
            
            // add
            for(int d=0; d < dir.length; d++){
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && visited[nr][nc] == false){
                    pq.add(new Pair(nr,nc,Math.max(time,grid[nr][nc])));
                }
            }
            
        }

        return 0;

    }
}