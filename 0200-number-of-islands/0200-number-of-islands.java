class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    char[][] grids;
    public int numIslands(char[][] grid) {
        grids = grid;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grids[i][j] == '1') {
                    dfs(i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int startI, int startJ) {
        grids[startI][startJ] = '2';

        for (int i = 0; i < 4; i++) {
            int nextI = startI + dx[i];
            int nextJ = startJ + dy[i];

            if (nextI < 0 || nextJ < 0 || nextI >= grids.length || nextJ >= grids[0].length) continue;
            if (grids[nextI][nextJ] != '1') continue;

            dfs(nextI, nextJ);
        }
    }
}