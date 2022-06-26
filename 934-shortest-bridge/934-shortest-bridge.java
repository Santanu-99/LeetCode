class Solution {
    class Pair{
        int r,c;
        Pair(){}
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    
    // dfs enqueue 1 cells and mark the visited
    public void dfs(int[][] grid,boolean[][] visited,Queue<Pair> qu,int sr,int sc){
        
        grid[sr][sc]=2;
        visited[sr][sc] = true;
        qu.add(new Pair(sr,sc));

        for(int d=0; d<dir.length; d++){
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1 && visited[nr][nc]==false){
                dfs(grid,visited,qu,nr,nc);
            }
        }
    }
    
    
    public int shortestBridge(int[][] grid) {
        
        Queue<Pair> qu = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        
        outerloop:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid,visited,qu,i,j);
                    break outerloop;
                }
            }
        }
        
        
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         System.out.print(visited[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int lvlCount=1;
        while(qu.size() > 0){
            int tempSize = qu.size();
            while(tempSize-- > 0){
                //remove
                Pair rem = qu.remove();
                int r = rem.r;
                int c = rem.c;
                
                

                //add
                for(int d=0; d<dir.length; d++){
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length){
                        if(grid[nr][nc]==0 && visited[nr][nc]==false){
                            visited[nr][nc] = true;
                            qu.add(new Pair(nr,nc));
                        }
                        else if(grid[nr][nc] == 1 && visited[nr][nc]==false){
                            return lvlCount-1;
                        }
                    }
                }
            }
            
            
            lvlCount++;    
        }
        
        
        return -1;
    }
}