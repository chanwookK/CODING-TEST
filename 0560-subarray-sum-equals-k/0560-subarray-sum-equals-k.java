class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        map.put(sum, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}