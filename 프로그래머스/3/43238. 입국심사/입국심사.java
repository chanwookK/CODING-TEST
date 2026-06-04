import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long right = (long) times[times.length - 1] * (n / times.length);
        return binarySearch(0, right, n, times);
    }
    
    public long binarySearch(long left, long right, int n, int[] times) {
        while (left < right) {
            long mid = (left + right) / 2;
            
            if (isPossible(mid, n, times)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean isPossible(long R, int n, int[] times) {
        long sum = 0;
        
        for (int time : times) {
            sum += R / time;
        }
        
        if (n <= sum) return true;
        return false;
    }
}