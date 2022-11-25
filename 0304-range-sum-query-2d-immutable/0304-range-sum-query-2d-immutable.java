class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {    
        mat = new int[matrix.length][matrix[0].length];
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                mat[r][c] = matrix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int r=row1;r<=row2;r++){
            for(int c=col1;c<=col2;c++){
                sum += mat[r][c];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */