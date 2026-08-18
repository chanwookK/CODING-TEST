class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        long max = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;

        for (int left = 1; left <= nums.length - k; left++) {
            int right = left + k - 1;

            sum -= nums[left - 1];
            sum += nums[right];

            if (max < sum) {
                max = sum;
            }
        }

        return (double) max / k;
    }
}