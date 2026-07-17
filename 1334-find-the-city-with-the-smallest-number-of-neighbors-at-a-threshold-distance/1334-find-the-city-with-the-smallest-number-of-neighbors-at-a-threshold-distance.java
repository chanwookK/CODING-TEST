class Solution {

    public int[][] result;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
                if (i == j) result[i][j] = 0;
            }
        }

        for (int[] edge : edges) {
            result[edge[0]][edge[1]] = edge[2];
            result[edge[1]][edge[0]] = edge[2];
        }

        floydWarshall();

        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] <= distanceThreshold) sum++;
            }
            if (answer >= sum) {
                answer = sum;
                index = i;
            }
            sum = 0;
        }

        return index;
    }

    public void floydWarshall() {
        for (int k = 0; k < result.length; k++) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    if (isMaxValue(result[i][k]) || isMaxValue(result[k][j])) continue;
                    result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                }
            }
        }
    }

    public boolean isMaxValue(int a) {
        return a == Integer.MAX_VALUE;
    }
}