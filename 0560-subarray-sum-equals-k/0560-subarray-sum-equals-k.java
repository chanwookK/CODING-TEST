class Solution {
    public int subarraySum(int[] nums, int k) {

        // sum, num of sum
        // 누적합 map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int cumulativeSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            if (map.getOrDefault(cumulativeSum - k, -1) != -1) {
                result += map.get(cumulativeSum - k);
            }
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }

        return result;
    }
}