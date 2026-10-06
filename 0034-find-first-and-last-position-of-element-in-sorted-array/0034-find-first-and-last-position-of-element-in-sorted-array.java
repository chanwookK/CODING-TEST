class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
    
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (left >= nums.length || left < 0 || nums[left] != target) return result;
        result[0] = left;

        left = 0;
        right = nums.length - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            
            if (nums[mid] <= target) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }

        result[1] = left;

        return result;
    }
}