class Solution {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int i = 1; i < amount + 1; i++) {
            int reqire = i;
            for (int c = 0; c < coins.length; c++) {
                int selectCoin = coins[c];
                if (reqire - selectCoin < 0) continue;
                if (reqire - selectCoin >= 0) {
                    if (dp[reqire - selectCoin] < 0) continue;
                    if (dp[reqire] > dp[reqire - selectCoin] + 1 || dp[reqire] == -1) dp[reqire] = dp[reqire - selectCoin] + 1;
                }
            }
        }

        return dp[amount];
    }
}