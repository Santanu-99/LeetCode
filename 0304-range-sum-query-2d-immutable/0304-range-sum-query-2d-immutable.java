class NumMatrix {
    int[][] mat;
    int[][] pre;
    public NumMatrix(int[][] matrix) {    
        mat = new int[matrix.length][matrix[0].length];
        pre = new int[matrix.length][matrix[0].length];

        int sum = 0;
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                mat[r][c] = matrix[r][c];
                sum = sum + mat[r][c];
                pre[r][c] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int r=row1;r<=row2;r++){
            if(r==0 && col1==0){
                sum = pre[r][col2];
                continue;
            }
            else if(col1==0){
                sum += pre[r][col2] - pre[r-1][mat[0].length-1];
                continue;
            }
            
            sum += pre[r][col2] - pre[r][col1-1]; 
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */