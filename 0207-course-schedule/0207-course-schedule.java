class Solution {

    int[] inDegree;
    List<Integer>[] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
for (int i = 0; i < numCourses; i++) {
    graph[i] = new ArrayList<>();
}        inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (queue.isEmpty()) return false;
            int cur = queue.poll();
            for (int neighbor : graph[cur]) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return true;
    }

    public int findInDegree0() {
        for (int ind : inDegree) {
            if (ind == 0) return ind;
        }
        return -1;
    }
}