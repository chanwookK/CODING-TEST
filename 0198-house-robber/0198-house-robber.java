class Solution {
    int[] maxMoney;
    public int rob(int[] nums) {
        maxMoney = new int[nums.length];
        maxMoney[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) maxMoney[i] = Math.max(nums[0], nums[1]);
            else if (maxMoney[i - 2] + nums[i] > maxMoney[i - 1]) {
                maxMoney[i] = maxMoney[i - 2] + nums[i];
            }
            else {
                maxMoney[i] = maxMoney[i - 1];
            }
        }

        return maxMoney[nums.length - 1];
    }
}