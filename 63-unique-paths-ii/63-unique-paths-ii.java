

class Solution {
    
    private static boolean inRange(int i,int j,int[][] maze){
        if(0<=i && 0<=j && i< maze.length && j< maze[0].length){
            return true;
        }
        
        return false;
    }

    
    private int getPaths(int sr,int sc,int[][] maze,int[][] dir,int[][] dp){
        
        if(sr==maze.length-1 && sc == maze[0].length-1){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        
        int count = 0;
        for(int d=0;d<dir.length;d++){
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            if(inRange(nr,nc,maze) && maze[nr][nc]==0){
                count += getPaths(nr,nc,maze,dir,dp);
            }
        }
        
        dp[sr][sc] = count;
        
        return count;
        
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        
        
        int[][] dir = {{0,1},{1,0}};
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        int count = getPaths(0,0,obstacleGrid, dir,dp);
        return count;
    }
}