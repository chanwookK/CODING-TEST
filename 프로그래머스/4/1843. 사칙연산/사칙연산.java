import java.util.*;

class Solution {
    
    int[][] dpMax;
    int[][] dpMin;
    int numberSize;
    int oppSize;
    int[] numbers;
    String[] opps;
    
    public int solution(String arr[]) {
        numberSize = arr.length / 2 + 1;
        oppSize = arr.length / 2;
        dpMax = new int[numberSize][numberSize];
        dpMin = new int[numberSize][numberSize];
        numbers = new int[numberSize];
        opps = new String[oppSize];
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
            }
            else {
                opps[i / 2] = arr[i];
            }
        }
        
        for (int i = 0; i < numberSize; i++) {
            for (int j = 0; j < numberSize - i; j++) {
                operation(j, j + i);
            }
        }
        
        return dpMax[0][numberSize - 1];
    }
    
    public void operation(int left, int right) {
        if (left == right) {
            dpMax[left][right] = numbers[left];
            dpMin[left][right] = numbers[left];
            return;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int pMax;
            int pMin;
            String operator = opps[i];
            if (operator.equals("+")) {
                pMax = dpMax[left][i] + dpMax[i + 1][right];
                pMin = dpMin[left][i] + dpMin[i + 1][right];
            }
            else {
                pMax = dpMax[left][i] - dpMin[i + 1][right];
                pMin = dpMin[left][i] - dpMax[i + 1][right];
            }
            
            if (pMax > max) max = pMax;
            if (pMin < min) min = pMin;
        }
        
        dpMax[left][right] = max;
        dpMin[left][right] = min;
    }
}