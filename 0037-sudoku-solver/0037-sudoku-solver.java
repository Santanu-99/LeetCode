class Solution {
    public void solveSudoku(char[][] board) {
        System.out.println(sudokuSolver(board , 0));
    }
    
    public boolean isSafe(char[][] board , int r , int c , char num){
        for(int i=0;i<board.length;i++){
            if(board[r][i] == num || board[i][c] == num){
                return false;
            }
        }
        
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        
        for(int i = 0;i<3;i++){
            for(int j=0;j<3;j++){
                int nr = sr + i;
                int nc = sc + j;
                if(board[nr][nc] == num){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void display(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print( board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public boolean sudokuSolver(char[][] board , int idx){
        if(idx == 9*9){
            display(board);
            System.out.println();
            return true;
        }

        int r = idx/9;
        int c = idx%9;
        

        if(board[r][c] !='.'){
            if(sudokuSolver(board , idx+1)) return true;
        } 
        else{
            for(int num=1;num<=9;num++){
                char n =(char)('0'+num);
                if(isSafe(board , r ,c ,n)){
                    board[r][c] = n;
                    if(sudokuSolver(board , idx+1)) return true;
                    board[r][c] = '.';
                }
            }
        }
        
        return  false;
    }
    
}