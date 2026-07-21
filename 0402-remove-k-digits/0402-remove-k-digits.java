class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArr = num.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < charArr.length; i++) {
            char current = charArr[i];
            while (!stack.isEmpty() && k != 0) {
                char peek = stack.peek();
                if (current >= peek) {
                    break;
                }
                else if (current < peek) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(current);
        }

        k = stack.size() - k;
        while (!stack.isEmpty() && k != 0) {
            result.append(stack.pollLast());
            k--;
        }
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }

        String answer = result.substring(index);

        return answer.isEmpty() ? "0" : answer;
    }
}