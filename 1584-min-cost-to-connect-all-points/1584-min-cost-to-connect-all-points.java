class Solution {

    Point[] parent;

    public int minCostConnectPoints(int[][] points) {
        parent = new Point[points.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        for (int i = 0; i < points.length; i++) {
            Point from = new Point(points[i][0], points[i][1], i);
            for (int j = 0; j < points.length; j++) {
                Point to = new Point(points[j][0], points[j][1], j);
                pq.offer(new Edge(from, to, distance(from, to)));
            }
            parent[i] = from;
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (union(cur.from, cur.to)) {
                answer += cur.dist;
            }
        }

        return answer;
    }

    public Point findParent(Point p) {
        if (p.num == parent[p.num].num) return parent[p.num];
        return findParent(parent[p.num]);
    }

    public boolean union(Point p1, Point p2) {
        Point parentP1 = findParent(p1);
        Point parentP2 = findParent(p2);
        if (parentP1.num == parentP2.num) return false;
        if (parentP1.num < parentP2.num) parent[parentP2.num] = parentP1;
        else parent[parentP1.num] = parentP2;
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