class NumArray {
    int[] cumulativeSum;
    int length;
    public NumArray(int[] nums) {
        cumulativeSum = new int[nums.length];
        length = nums.length;
        if (nums.length == 0) return;

        cumulativeSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cumulativeSum[i] = nums[i] + cumulativeSum[i - 1];
        }        
    }
    
    public int sumRange(int left, int right) {
        if (left >= length || right >= length || left > right) return -1;
        if (left == 0) return cumulativeSum[right];
        return cumulativeSum[right] - cumulativeSum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */