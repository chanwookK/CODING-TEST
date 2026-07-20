class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> {
            int aFreq = a.getValue();
            int bFreq = b.getValue();

            if (aFreq!=bFreq) return Integer.compare(bFreq, aFreq);
            return Character.compare(a.getKey(), b.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> c : entryList) {
            for (int i = 0; i < c.getValue(); i++) {
                sb.append(c.getKey());
            }
        }
        return sb.toString();
    }
}