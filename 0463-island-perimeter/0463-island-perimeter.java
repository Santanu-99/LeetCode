class Solution {
    int[][] dir ={{0,1},{1,0},{0,-1},{-1,0}};
    
    public int islandPerimeter(int[][] grid) {
        int sr=0 , sc=0 ;
        boolean stop = false;
        for(int r=0;r<grid.length && !stop;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    sr=r;
                    sc=c;
                    stop = true;
                    break;
                }
            }
        }
        
        int ans = getPerimeter(grid,sr,sc);
        return ans;
    }
    
    int getPerimeter(int[][] grid , int r, int c){
        int currP = calculatePerimeter(grid,r,c);
        // System.out.println("( "+r+","+c+" )=> "+currP);
        grid[r][c]=2;

        for(int d=0;d<dir.length;d++){
            int nr = r+dir[d][0];
            int nc = c+dir[d][1];
            
            if( 0<=nr && nr< grid.length && 0<=nc && nc< grid[0].length && grid[nr][nc] == 1){
                int recP = getPerimeter(grid,nr,nc);
                currP += recP;
            }
        }
        return currP;
    }
    
    int calculatePerimeter(int[][] grid,int r , int c){
        int p = 0;
        for(int d=0;d<dir.length;d++){
            int nr = r+dir[d][0];
            int nc = c+dir[d][1];
            
            if( 0>nr || nr>= grid.length || 0>nc || nc>= grid[0].length || grid[nr][nc] == 0){
                p += 1;
            }
        }
        return p;
    }
}