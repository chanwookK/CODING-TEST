class Solution {

    int[] parent;

    public int minCostConnectPoints(int[][] points) {
        parent = new int[points.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        for (int i = 0; i < points.length; i++) {
            Point from = new Point(points[i][0], points[i][1], i);
            for (int j = 0; j < points.length; j++) {
                Point to = new Point(points[j][0], points[j][1], j);
                pq.offer(new Edge(from, to, distance(from, to)));
            }
            parent[i] = i;
        }

        int selectedEdgeNum = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.from.num, cur.to.num)) {
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

    public int distance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    
}

class Edge {
    Point from;
    Point to;
    int dist;

    public Edge(Point from, Point to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}

class Point {
    int x;
    int y;
    int num;


    public Point(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}