class Solution {
    public int findMaxLength(int[] nums) {
        // Sum, 최소 Index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) sum += -1;
            else sum += 1;
            int index = map.getOrDefault(sum, -2);
            if (index != -2) {
                int sequence = i - index;
                if (sequence > result) result = sequence;
            }
            int curIndex = map.getOrDefault(sum, -2);
            if (index == -2) {
                map.put(sum, i);
            }
        }
        return result;
    }
}