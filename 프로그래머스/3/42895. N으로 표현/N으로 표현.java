import java.util.*;

class Solution {
    
    public Set<Integer>[] dp;
    
    public int solution(int N, int number) {        
        dp = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        if (N == number) return 1;
        
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int left : dp[j]) {
                    for (int right : dp[i - j]) {
                        dp[i].add(left + right);
                        dp[i].add(left * right);
                        if (right != 0) {
                            dp[i].add(left / right);
                        }
                        dp[i].add(left - right);
                    }
                }
            }
            String nString = String.valueOf(N);
            dp[i].add(Integer.parseInt(nString.repeat(i)));
            
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}