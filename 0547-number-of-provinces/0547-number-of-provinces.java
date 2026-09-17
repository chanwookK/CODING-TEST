class Solution {

    boolean[] visited;
    int[][] isConnecteds;

    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        isConnecteds = isConnected;
        int result = 0;
        for (int i = 0; i < isConnecteds.length; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }

        }
        return result;
    }

    public void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < isConnecteds[node].length; i++) {
            int nextNode = i;
            if (visited[nextNode]) continue;
            if (isConnecteds[node][nextNode] == 0) continue;

            dfs(nextNode);
        }

    }
}