class NumMatrix {

    int[][] sum;
    int R;
    int C;
    public NumMatrix(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;

        sum = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0) {
                    if (j == 0) sum[i][j] = matrix[i][j];
                    else sum[i][j] = sum[i][j - 1] + matrix[i][j];
                }
                else if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + matrix[i][j];
                }
                else {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        if (row1 == 0 && col1 == 0) {
            result = sum[row2][col2];
        }
        else if (row1 == 0) {
            result = sum[row2][col2] - (sum[row2][col1 - 1]);
        }
        else if (col1 == 0) {
            result = sum[row2][col2] - (sum[row1 - 1][col2]);    
        }
        else {
            result = sum[row2][col2] - (sum[row2][col1 - 1] + sum[row1 - 1][col2]) + sum[row1 - 1][col1 - 1];
        }

        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */