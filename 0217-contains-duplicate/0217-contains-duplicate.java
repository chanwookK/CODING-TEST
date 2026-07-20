class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (set.contains(current)) return true;
            set.add(current);
        }
        return false;
    }
}