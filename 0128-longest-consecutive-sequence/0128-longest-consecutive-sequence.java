class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }        

        int result = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int sequence = sequenceSearch(numSet, num);
                if (sequence > result) result = sequence;
            }
        }

        return result;
    }

    public int sequenceSearch(Set<Integer> numSet, int start) {
        int result = 1;
        while (true) {
            if (numSet.contains(start + 1)) {
                result++;
                start += 1;
            }
            else break;
        }

        return result;
    }
}