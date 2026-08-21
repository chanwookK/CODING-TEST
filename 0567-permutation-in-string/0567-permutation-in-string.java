class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        if (s1.length() > s2.length()) return false;

        char[] s1Char = s1.toCharArray();
        for (char c : s1Char) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = s1.length() - 1;
        char[] s2Char = s2.toCharArray();

        for (int i = left; i <= right; i++) {
            map.put(s2Char[i], map.getOrDefault(s2Char[i], 0) - 1);
        }
        left++;
        right++;
        if (test(map)) return true;

        for (int i = right; i < s2Char.length; i++) {
            map.put(s2Char[right], map.getOrDefault(s2Char[right], 0) - 1);
            map.put(s2Char[left - 1], map.getOrDefault(s2Char[left - 1], 0) + 1);
            left++;
            right++;
            if(test(map)) return true;
        }

        return false;
    }

    public boolean test(Map<Character, Integer> map) {
        for (int v : map.values()) {
            if (v != 0) return false;
        }
        return true;
    }
}