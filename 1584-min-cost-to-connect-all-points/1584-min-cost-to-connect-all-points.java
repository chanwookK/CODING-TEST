class Solution {

    int[] parent;

    public int minCostConnectPoints(int[][] points) {
        parent = new int[points.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                pq.offer(new Edge(i, j, distance(points[i], points[j])));
            }
            parent[i] = i;
        }

        int selectedEdgeNum = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.from, cur.to)) {
                answer += cur.dist;
                selectedEdgeNum++;
            }
            if(selectedEdgeNum == points.length - 1) return answer;
        }

        return answer;
    }

    public int findParent(int pNum) {
        if (pNum == parent[pNum]) return parent[pNum];
        return findParent(parent[pNum]);
    }

    public boolean union(int p1, int p2) {
        int parentP1 = findParent(p1);
        int parentP2 = findParent(p2);
        if (parentP1 == parentP2) return false;
        if (parentP1 < parentP2) parent[parentP2] = parentP1;
        else parent[parentP1] = parentP2;
        return true;
    }

    public int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    
}

class Edge {
    int from;
    int to;
    int dist;

    public Edge(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}
