class Solution {
    
    private class Pair{
        int i,j;
        
        Pair(){}
        
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    
    private int init(int[][] grid,Queue<Pair> qu){   
        int freshOranges = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        return freshOranges;
    }
    
    int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> qu = new LinkedList<>();
        int freshOrange = init(grid,qu);
        int time =0;
        while(qu.size() != 0){
            int tempSize = qu.size();
            if(freshOrange == 0){
                break;
            }
            
            while(tempSize-- > 0){

                Pair rm = qu.remove();

                for(int[] d: dir){
                    int r = rm.i + d[0];
                    int c = rm.j + d[1];
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        freshOrange--;
                        qu.add(new Pair(r,c));

                    }
                }
            }
            time++;
        }

        
        return freshOrange == 0 ? time : -1;
    }
}