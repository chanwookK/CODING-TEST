class Solution {
    int startColor;
    boolean[][] visited;
    int[][] images;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        startColor = image[sr][sc];
        visited = new boolean[image.length][image[0].length];
        images = image;
        floodFill(color, sr, sc);
        return images;
    }

    public void floodFill(int color, int x, int y) {
        visited[x][y] = true;
        if (images[x][y] == color || images[x][y] != startColor) return;
        if (images[x][y] == startColor) images[x][y] = color;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= images.length || nextY >= images[0].length) continue;
            if (visited[nextX][nextY]) continue;
            floodFill(color, nextX, nextY);
        }
    }
}