class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        int loop = sb.length();
        for (int i = 0; i < loop; i++) {
            String baseString = sb.toString();
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(baseString)) break;
                if (j == strs.length - 1) return baseString;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return "";
    }
}