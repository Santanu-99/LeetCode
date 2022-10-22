class Solution {
    int row[] , col[] , subMat[][] ;
    public void solveSudoku(char[][] board) {
        row = new int[9];
        col = new int[9];
        subMat = new int[3][3];
        setBits(board);
        sudokuSolver(board , 0);
    }
    
    public void setBits(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                else{
                    int num = board[i][j] - '0';
                    toggleBit(i,j,num);
                }
            }
        }
    }
    
    public void toggleBit(int r ,int c ,int num){
        row[r] ^= (1 << num);
        col[c] ^= (1 << num);
        int sr = r / 3;
        int sc = c / 3;
        subMat[sr][sc] ^= (1 << num);
        
    }
    
    public boolean isSafe2(char[][] board , int r , int c , int n){
        
        if((row[r] & (1<<n)) != 0){
            return false;
        }
        if((col[c] & (1<<n)) != 0){
            return false;
        }
        
        int sr = r / 3 ;
        int sc = c / 3 ;
        
        if((subMat[sr][sc] & (1<<n)) != 0 ){
            return false;
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
            // display(board);
            // System.out.println();
            return true;
        }

        int r = idx/9;
        int c = idx%9;
        

        if(board[r][c] !='.'){
            if(sudokuSolver(board , idx+1)) return true;
        } 
        else{
            for(int num=1;num<=9;num++){
                if(isSafe2(board , r ,c ,num)){
                    toggleBit(r,c,num);
                    board[r][c] = (char)('0'+num);
                    if(sudokuSolver(board , idx+1)) return true;
                    board[r][c] = '.';
                    toggleBit(r,c,num);

                }
            }
        }
        
        return  false;
    }
    
}