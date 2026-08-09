class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0? -1 : 1;

            if (map.getOrDefault(sum, -2) == -2) {
                map.put(sum, i);
            }

            if (map.getOrDefault(sum, -2) != -2) {
                if (result < i - map.get(sum)) result = i - map.get(sum);
            }
        }

        return result;
    }
}