import java.util.*;
class Solution {
    
    public List<Integer>[] winGraph;
    public List<Integer>[] defeatGraph;
    public boolean[] winVisited;
    public boolean[] defeatVisited;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        winGraph = new ArrayList[n + 1];
        defeatGraph = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            winGraph[i] = new ArrayList<>();
            defeatGraph[i] = new ArrayList<>();
        }
        
        for (int[] result : results) {
            winGraph[result[0]].add(result[1]);
            defeatGraph[result[1]].add(result[0]);
        }
        
        for (int i = 1; i < n + 1; i++) {
            winVisited = new boolean[n + 1];
            defeatVisited = new boolean[n + 1];
            int result = bfs(i);
            if (result == n) answer++;
        }
        return answer;
    }
    
    public int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        winVisited[start] = true;
        defeatVisited[start] = true;
        int totalVisit = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int win : winGraph[current]) {
                if (winVisited[win]) continue;
                queue.offer(win);
                winVisited[win] = true;
                totalVisit++;
            }
        }
        
        queue.offer(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int defeat : defeatGraph[current]) {
                if (defeatVisited[defeat]) continue;
                queue.offer(defeat);
                defeatVisited[defeat] = true;
                if (!winVisited[defeat]) totalVisit++;
            }
        }
        
        return totalVisit;
    }
}