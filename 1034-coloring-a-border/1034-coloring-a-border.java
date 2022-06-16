class Solution {
    public class Pair{
        int r ,c;
        Pair(){}
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    
    
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    
    
    public boolean isBoundary(int[][]grid , int sr,int sc,int ocolor,int bcolor,boolean[][] visited){
        if(0==sr || 0==sc || sr==grid.length-1 || sc == grid[0].length-1){
            return true;
        }else{
            for(int d=0; d<dir.length; d++){
                int nr = sr + dir[d][0];
                int nc = sc + dir[d][1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length ){
                    if(visited[nr][nc]==false && grid[nr][nc]==bcolor){
                        return true;
                    }
                    else if(grid[nr][nc] != ocolor && grid[nr][nc] != bcolor){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(row,col));
        visited[row][col] = true;
        int ocolor = grid[row][col];

        if(isBoundary(grid,row,col,ocolor,color,visited)){
            grid[row][col] = color;
        }
        
        
        while(qu.size() > 0){
            
            //remove
            Pair rem = qu.remove();
            int r = rem.r;
            int c = rem.c;
            
            //work
            if(isBoundary(grid,r,c,ocolor,color,visited)){
                grid[r][c] = color;
            }
            
            //mark and add;
            for(int d=0; d<dir.length; d++){
                int nr = r+dir[d][0];
                int nc = c +dir[d][1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==ocolor && visited[nr][nc] == false ){
                    visited[nr][nc] = true;
                    qu.add(new Pair(nr,nc));
                }
            }
        }
        
        return grid;
    }
}