import java.util.*;

class Solution {
    
    public boolean[] visited;
    public List<Integer>[] graph;
    public int answer = Integer.MAX_VALUE;
    public int sum = 0;
    
    public int solution(int n, int[][] wires) {
        visited = new boolean[n + 1];
        graph = new LinkedList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            
            int a = -1;
            int b = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    int result = dfs(i);
                    sum = 0;
                    if (a < 0) a = result;
                    else b = result;
                }
            }
            int gap = Math.abs(a - b);
            if (answer > gap) answer = gap;
            
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
            visited = new boolean[n + 1];
        }
        
        return answer;
    }
    
    public int dfs(int start) {
        sum++;
        visited[start] = true;
        
        for (int node : graph[start]) {
            if (visited[node]) continue;
            dfs(node);
        }
        return sum;
    }
}