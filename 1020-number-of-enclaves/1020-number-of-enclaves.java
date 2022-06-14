class Solution {
    
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public class Pair{
        int r,c;
        Pair(){}
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    
    private int bfs(int[][] grid,int sr,int sc){
        int len = 0;
        boolean valid = true;
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(sr,sc));
        while(qu.size() > 0){
            Pair rem = qu.remove();
            if(grid[rem.r][rem.c] == 2){
                continue;
            }
            grid[rem.r][rem.c] = 2;
            len++;
            for(int d=0;d<dir.length;d++){
                int nr = rem.r + dir[d][0];
                int nc = rem.c + dir[d][1];
                if(0<=nr && 0<=nc && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 1){
                    qu.add(new Pair(nr,nc));
                }else if(0>nr || 0>nc || nr>=grid.length || nc>=grid[0].length){
                    valid = false;
                }
            }
        }
        len = valid == true ? len : 0;
        return len;
    }
    
    
    public int numEnclaves(int[][] grid) {
        int totLen = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int len = bfs(grid,i,j);
                    totLen += len;
                }
            }
        }
        
        return totLen;
    }
}