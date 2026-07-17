class Solution {

    long[][] costs;
    int ALPABET_NUM = 26;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        costs = new long[ALPABET_NUM][ALPABET_NUM];

        for (int i = 0; i < ALPABET_NUM; i++) {
            for (int j = 0; j < ALPABET_NUM; j++) {
                if (i == j) costs[i][j] = 0;
                else costs[i][j] = Long.MAX_VALUE;
            }
        }

        for (int i = 0; i < cost.length; i++) {
            if (costs[original[i] - 'a'][changed[i] - 'a'] > (long) cost[i]) {
                costs[original[i] - 'a'][changed[i] - 'a'] = (long) cost[i];
            }
        }

        floydWarShall();

        long answer = 0L;
        for (int i = 0; i < source.length(); i++) {
            if (costs[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Long.MAX_VALUE) return -1;
            answer += costs[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        return answer;
    }

    public void floydWarShall() {
        for (int k = 0; k < costs.length; k++) {
            for (int i = 0; i < costs.length; i++) {
                for (int j = 0; j < costs.length; j++) {
                    if (costs[i][k] == Long.MAX_VALUE || costs[k][j] == Long.MAX_VALUE) continue;
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }
    }
}