class Solution {
    private class Pair{
        int i,j;
        Pair(){}
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    private Pair nextIsland(char[][] grid){
        
        int i=0,j=0;
        while(i<grid.length && j < grid[0].length){
//             check island start
            if(grid[i][j] == '1'){
                return new Pair(i,j);
            }
            
//             next cell
            j++;
            if(j == grid[0].length){
                j=0;
                i++;
            }
        }
        
        return new Pair(i,j);
    }
    
    
    private void sinkIsland(char[][] grid,int sr,int sc){
        
        if(sr<0 || sc < 0 || sr == grid.length || sc == grid[0].length){
            return;
        }
        
        if(grid[sr][sc] == '1'){
            grid[sr][sc] = '0';
            sinkIsland(grid,sr-1,sc);
            sinkIsland(grid,sr,sc-1);
            sinkIsland(grid,sr+1,sc);
            sinkIsland(grid,sr,sc+1);
            
        }
    }
    
    
    public int numIslands(char[][] grid) {
        int count =0;
        int xl = grid[0].length;
        int yl = grid.length;
        
        Pair startPoint = nextIsland(grid);
        while(startPoint.i < yl && startPoint.j < xl){
            count++;
            sinkIsland(grid,startPoint.i,startPoint.j);
            startPoint = nextIsland(grid);
        }
        
        return count;
        
    }
}