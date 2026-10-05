class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int orangeNum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int[] rottenCoord = new int[2];
                    rottenCoord[0] = i;
                    rottenCoord[1] = j;
                    queue.offer(rottenCoord);
                }
                else if (grid[i][j] == 1) orangeNum++;
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (orangeNum == 0) break;
            for (int k = 0; k < size; k++) {
                int[] current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextI = current[0] + dx[i];
                    int nextJ = current[1] + dy[i];

                    if (nextI < 0 || nextJ < 0 || nextI >= grid.length || nextJ >= grid[0].length) continue;
                    if (grid[nextI][nextJ] != 1) continue;
                    grid[nextI][nextJ] = 2;
                    orangeNum--;

                    int[] nextCoord = new int[2];
                    nextCoord[0] = nextI;
                    nextCoord[1] = nextJ;
                    queue.offer(nextCoord);
                }
            }
            time++;
        }
        if (orangeNum != 0) return -1;
        return time;
    }
}