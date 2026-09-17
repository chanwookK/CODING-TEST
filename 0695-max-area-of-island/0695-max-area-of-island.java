class Solution {

    int[][] grids;
    int answer = 0;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        grids = grid;
        visited = new boolean[grids.length][grids[0].length];

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (!visited[i][j] && grids[i][j] != 0) bfs(i, j);
                if (answer > result) result = answer;
                answer = 0;
            }
        }

        return result;
    }

    public void bfs(int x, int y) {
        visited[x][y] = true;
        answer++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= grids.length || nextY >= grids[0].length) continue;
            if (visited[nextX][nextY]) continue;
            if (grids[nextX][nextY] == 0) continue;

            bfs(nextX, nextY);
        }
    }
}