class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            String sortedStr = new String(cstr);

            List<String> value = map.getOrDefault(sortedStr, new ArrayList<>());
            value.add(str);
            map.putIfAbsent(sortedStr, value);
        }

        return map.values().stream().toList();
    }
}