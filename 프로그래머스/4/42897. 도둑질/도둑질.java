import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        if (n == 1) return money[0];
        if (n == 2) return Math.max(money[0], money[1]);
        
        
        return Math.max(
            rob(0, n - 2, money),
            rob(1, n - 1, money)
        );
    }
    
    public int rob(int start, int end, int[] money) {
        int n = end - start + 1;
        int[] dp = new int[n];
        
        dp[0] = money[0 + start];
        dp[1] = Math.max(money[0 + start], money[1 + start]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(
                dp[i - 1],
                dp[i - 2] + money[i + start]
            );
        }
        
        return dp[n - 1];
    }
}