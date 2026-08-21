class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        int left = 0;
        int result = 1;
        map.put(sChar[0], 1);

        for (int right = 1; right < s.length(); right++) {
            map.put(sChar[right], map.getOrDefault(sChar[right], 0) + 1);
            
            while (!test(map, k)) {
                map.put(sChar[left], map.getOrDefault(sChar[left], 0) - 1);
                left++;
            }

            int partResult = right - left + 1;

            if (partResult > result) result = partResult;
        }

        return result;
    }

    public boolean test(Map<Character, Integer> map, int k) {
        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Collections.reverseOrder());

        boolean flag = true;
        for (int v : values) {
            if (flag) {
                flag = false;
                continue;
            }

            k -= v;
        }

        if (k >= 0) return true;
        return false;
    }
}