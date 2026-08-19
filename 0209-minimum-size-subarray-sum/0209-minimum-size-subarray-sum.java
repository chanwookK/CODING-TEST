class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                if (result == 0 || result > right - left + 1) {
                    result = right - left + 1;
                }
                if (left == right) return 1;
                sum -= nums[left++];
            }
        }
        return result;
    }
}