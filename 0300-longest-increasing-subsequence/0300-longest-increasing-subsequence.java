class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j] > max) max = dp[j];
                }
            }
            dp[i] = max + 1;
            if (result < dp[i]) result = dp[i];
        }
        return result;  
    }
}