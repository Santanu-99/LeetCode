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
    
    public int init(int[][] grid , Queue<Pair> qu){
        int fresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        return fresh;
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> qu = new LinkedList<>();
        int fresh = init(grid,qu);
        int time = -1;
        
        while(qu.size() > 0){
            int tempSize = qu.size();
            
            while(tempSize-- > 0){
                Pair rem = qu.remove();
                for(int d=0;d<dir.length;d++){
                    int nr = rem.r + dir[d][0];
                    int nc = rem.c + dir[d][1];
                    if(0<=nr && 0<=nc && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        qu.add(new Pair(nr,nc));
                        fresh--;
                    }
                }
                
            }
            time++;
        }
        
//         If there were no fresh oranges to begin with
        if(time == -1 && fresh == 0){
            return 0;
        }
        
//         If all the fresh oranges are gone or not
        time = fresh == 0 ? time : -1;
        return time;
        
    }
}