class Solution {
    public int slidingPuzzle(int[][] board) {
        
        // creating string representation of board
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length ; j++){
                sb.append(board[i][j]);
            }
        }
        
        // given string
        String root = sb.toString();
        
        
        // target string
        String target = "123450";
        
        // direction map
        int[][] dirMap = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        
        Queue<String> qu = new LinkedList<>();
        qu.add(root);
        int lvl = 0;
        
        HashSet<String> vis = new HashSet<>();
        
        while(qu.size() != 0){
            
            int tempSize = qu.size();
            
            for(int i=0;i<tempSize;i++){
            
                //remove
                String rem = qu.remove();

                
                //work
                if(vis.contains(rem)){
                    continue;
                }
                else if(rem.equals(target)){
                    return lvl;
                }
                
                //mark
                vis.add(rem);
                
                //add
                int zeroPos = rem.indexOf('0');
                
                for(int nextPos : dirMap[zeroPos]){
                    String newStr = swap(rem,zeroPos , nextPos);
                    if(!vis.contains(newStr)){
                        qu.add(newStr);                        
                    }
                }
            }
            lvl++;
        }
        
        return -1;
    }
    
    String swap(String str , int i , int j){
        StringBuilder sb = new StringBuilder(str);
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);

        sb.setCharAt(i,chj);
        sb.setCharAt(j,chi);
        
        return sb.toString();
    }
}