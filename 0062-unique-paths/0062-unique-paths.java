class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways;
        ways = new int[m][n];
        Arrays.fill(ways[0], 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) ways[i][j] = 1;
                else ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }
}