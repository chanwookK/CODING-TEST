class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            
            List<String> putStringList = map.getOrDefault(sortedStr, new ArrayList<>());
            putStringList.add(str);
            map.put(sortedStr, putStringList);
        }

        return map.values().stream().toList();
    }
}