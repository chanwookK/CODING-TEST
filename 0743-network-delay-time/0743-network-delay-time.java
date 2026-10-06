class Solution {

    int[] dp;
    boolean[] visited;
    List<Edge>[] graph;
    int INF = Integer.MAX_VALUE;

    public int networkDelayTime(int[][] times, int n, int k) {
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = INF;
        }
        
        visited = new boolean[n];
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] time : times) {
            graph[time[0] - 1].add(new Edge(time[1] - 1, time[2]));
        }
        
        dijkstra(k - 1);

        int result = -1;
        for (int i = 0; i < dp.length; i++) {
            if (result < dp[i]) result = dp[i];
        }
        if (result == INF) return -1;
        return result;
    }

    public void dijkstra(int start) {
        dp[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.num]) continue;
            visited[cur.num] = true;

            for (Edge e : graph[cur.num]) {
                if (dp[e.to] > cur.cost + e.cost) {
                    dp[e.to] = cur.cost + e.cost;
                    pq.offer(new Node(e.to, dp[e.to]));
                }
            }
        }

    }
}

class Node {
    int num;
    int cost;

    public Node(int num, int cost){
        this.num = num;
        this.cost = cost;
    }
}

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    } 
}