class Solution {
    public String reverseWords(String s) {

        String[] strArray = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArray.length - 1; i >= 0; i--) {
            if (strArray[i].isBlank()) continue;
            sb.append(strArray[i]);
            if (i!=0) sb.append(" ");
        }

        return sb.toString();
    }
}