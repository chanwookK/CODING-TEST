class Solution {
    public int subarraySum(int[] nums, int k) {
        int cumulativeSum[] = new int[nums.length];
        cumulativeSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + nums[i];
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    if (cumulativeSum[i] == k) result++;
                }
                else {
                    if (cumulativeSum[i] - cumulativeSum[j - 1] == k) result++;
                }
            }
        }

        return result;
    }
}