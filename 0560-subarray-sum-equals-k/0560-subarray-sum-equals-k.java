class Solution {
    public int subarraySum(int[] nums, int k) {
        // 누적합, 갯수
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 정답
        int result = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            result += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return result;
    }

}