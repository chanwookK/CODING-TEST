class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        char[] strArray = s.toCharArray();
        Character[] charArray = new Character[strArray.length];
        int i = 0;
        for (char c : strArray) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            charArray[i++] = c;
        }
        
        Arrays.sort(charArray, (a, b) -> {
            if (a == b) {
                return 0;
            }
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);

            if (freqA > freqB) return -1;
            if (freqA < freqB) return 1;
            return Character.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }
        return sb.toString();
    }
}