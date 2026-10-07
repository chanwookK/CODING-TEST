class Solution {
    int row;
    int col;
    int[] dr = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dc = {0, 0, 1, -1, -1, 1, 1, -1};

    public void gameOfLife(int[][] board) {
        row = board.length;
        col = board[0].length;

        int[][] nextBoard = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int numOfNeighbors = numOfNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (numOfNeighbors == 3) nextBoard[i][j] = 1;
                    continue;
                }
                if (numOfNeighbors > 3) nextBoard[i][j] = 0;
                else if (numOfNeighbors > 1) nextBoard[i][j] = 1;
                else nextBoard[i][j] = 0;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                board[i][j] = nextBoard[i][j];
            }
        }
    }

    public int numOfNeighbors(int[][] board, int r, int c) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];

            if (nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col) continue;

            if (board[nextRow][nextCol] == 1) result++; 
        }
        return result;
    }
}