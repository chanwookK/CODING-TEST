class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hash = new HashMap<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (char c : sChar) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (char c : tChar) {
            hash.put(c, hash.getOrDefault(c, 0) - 1);
        }

        for (int result : hash.values()) {
            if (result != 0) return false;
        }

        return true;
    }
}