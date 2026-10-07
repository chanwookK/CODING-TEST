class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int result = 1;
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = 1;
        Map<Character, Integer> hash = new HashMap<>();
        hash.put(charArr[0], 0);

        while (right != s.length()) {
            char current = charArr[right];
            if (!hash.containsKey(current)) {
                right++;
                if (result < right - left) result = right - left;
            }
            else {
                int curIndex = hash.get(current);
                for (int i = left; i <= curIndex; i++) {
                    hash.remove(charArr[i]);
                    left++;
                }
                right++;
            }
            hash.put(current, right - 1);
        }

        return result;
    }
}