class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    int X;
    int Y;
    int totalDot;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        X = matrix[0].length;
        Y = matrix.length;    
        totalDot = X * Y;
        visited = new boolean[Y][X];

        int x = 0;
        int y = 0;
        int i = 0;
        while (totalDot != 0) {
            visited[y][x] = true;
            totalDot--;
            answer.add(matrix[y][x]);
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= X || nextY >= Y || nextX < 0 || nextY < 0) {
                i++;
            }
            else if (visited[nextY][nextX] == true) {
                i++;
            }
            i %= 4;
            x += dx[i];
            y += dy[i];
        }

        return answer;
    }
}