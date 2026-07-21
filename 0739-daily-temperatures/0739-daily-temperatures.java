import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Temp> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        stack.push(new Temp(temperatures[0], 0));

        for (int i = 1; i < temperatures.length; i++) {
            Temp current = new Temp(temperatures[i], i);
            while (!stack.isEmpty()) {
                Temp peek = stack.peek();
                if (current.temp > peek.temp) {
                    stack.pop();
                    result[peek.index] = current.index - peek.index;
                }
                else break;
            }
            stack.push(current);
        }

        return result;
    }
}

class Temp {
    int temp;
    int index;

    public Temp(int temp, int index) {
        this.temp = temp;
        this.index = index;
    }
}