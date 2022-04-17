class Solution {
    
    int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
    
    private int dfs(int[][] grid , int sr , int sc){
        int area = 1;
        grid[sr][sc] = 0;
        for(int i=0;i<dir.length;i++){
            int nr = sr+dir[i][0];
            int nc = sc+dir[i][1];
            
            if(0<= nr && nr < grid.length && 0<= nc && nc < grid[0].length && grid[nr][nc] == 1){
                area = area + dfs(grid,nr,nc);
            }
        }
        return area;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j =0;j <grid[0].length;j++){
                if(grid[i][j] != 0){
                    int area = dfs(grid,i,j);
                    if(maxArea < area){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
}