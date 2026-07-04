import java.util.*;

class Solution {
    
    public int[] number;
    public int answer  = 0;
    
    public int solution(int[] numbers, int target) {
        number = numbers;
        dfs(0, 0, target);
        return answer;
    }
    
    public void dfs(int start, int sum, int target) {
        if (start == number.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(start + 1, sum + number[start], target);
        dfs(start + 1, sum - number[start], target);
    }
    
    
}