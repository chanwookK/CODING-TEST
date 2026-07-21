import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Value> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        boolean[] isCalc = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Value current = new Value(nums[i], i);
            while (!stack.isEmpty()) {
                Value peek = stack.peek();
                if (peek.value < current.value) {
                    stack.pop();
                    isCalc[peek.index] = true;
                    result[peek.index] = current.value;
                }
                else break;
            }
            stack.push(current);
        }

        for (int i = 0; i < nums.length; i++) {
            Value current = new Value(nums[i], i);
            while (!stack.isEmpty()) {
                Value peek = stack.peek();
                if (peek.value < current.value) {
                    stack.pop();
                    isCalc[peek.index] = true;
                    result[peek.index] = current.value;
                }
                else break;
            }
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            if (isCalc[stack.peek().index]) stack.pop();
            else result[stack.pop().index] = -1;
        }

        return result;
    }
}

class Value {
    int value;
    int index;

    Value(int value, int index) {
        this.value = value;
        this.index = index;
    }
}