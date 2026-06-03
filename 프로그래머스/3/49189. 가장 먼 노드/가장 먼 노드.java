import java.util.*;

class Solution {
    
    public List<Integer>[] graph;
    public Integer[] distance;
    public boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n + 1];
        distance = new Integer[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        bfs();
        Arrays.sort(distance, Comparator.reverseOrder());
        
        int previous = -1;
        for (int d : distance) {
            if (previous == -1 || previous == d) {
                answer++;
                previous = d;
            }
            else {
                break;
            }
        }
        return answer;
    }
    
    public void bfs() {
        Deque<Node> queue = new ArrayDeque<>();
        distance[0] = 0;
        distance[1] = 0;
        visited[1] = true;
        queue.offer(new Node(1, 0));
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (int next : graph[current.num]) {
                if (visited[next]) continue;
                queue.offer(new Node(next, current.distance + 1));
                visited[next] = true;
                distance[next] = current.distance + 1;
            }
        }
    }
    
    public class Node {
        int num;
        int distance;
        
        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}