import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");

        String lastword = "";
        while (st.hasMoreTokens()) {
            lastword = st.nextToken();
        }

        return lastword.length();
    }
}