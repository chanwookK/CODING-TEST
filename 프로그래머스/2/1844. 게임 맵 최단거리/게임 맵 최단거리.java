import java.util.*;

class Solution {
    int[][] map;
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        map = maps;
        visited = new boolean[maps.length][maps[0].length];
        return bfs(0, 0);
    }
    
    public int bfs(int startX, int startY) {
        Deque<XY> queue = new ArrayDeque<>();
        queue.offer(new XY(startX, startY, 1));
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            XY current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) continue;
                if (map[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;
                if (nextX == map.length - 1 && nextY == map[0].length - 1) return current.moveCount + 1;
                visited[nextX][nextY] = true;
                XY next = new XY(nextX, nextY, current.moveCount + 1);
                queue.offer(next);
            }
        }
        return -1;
    }
}

class XY {
    int x;
    int y;
    int moveCount;
    
    public XY(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }
}