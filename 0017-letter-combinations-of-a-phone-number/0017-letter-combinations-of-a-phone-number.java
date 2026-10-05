class Solution {

    String[][] strings = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        dfs(0, digits, "");
        return result;
    }

    public void dfs(int start, String digits, String word) {
        if (start == digits.length()) {
            result.add(word);
            return;
        }

        int currentDigits = digits.charAt(start) - '0';

        for (int i = 0; i < strings[currentDigits].length; i++) {
            dfs(start + 1, digits, word + strings[currentDigits][i]);
        }

    }
}