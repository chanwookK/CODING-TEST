class Solution {
    public int maxVowels(String s, int k) {
        char[] str = s.toCharArray();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            char current = str[i];

            if (isVowel(current)) {
                sum++;
            }
        }
        max = sum;

        for (int left = 1; left <= s.length() - k; left++) {
            int right = left + k - 1;
            char leftChar = str[left - 1];
            char rightChar = str[right];

            if (isVowel(leftChar)) sum--;
            if (isVowel(rightChar)) sum++;

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }

    public boolean isVowel(char target) {
        if (target == 'a' || target == 'e' || target == 'i' || target == 'o' || target == 'u') {
            return true;
        }
        return false;
    }
}