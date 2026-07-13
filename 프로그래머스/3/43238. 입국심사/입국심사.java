import java.util.*;

class Solution {
    int[] sortedTimes;
    int N;
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        sortedTimes = times;
        N = n;
    
        return binarySearch(1, (long) times[0] * n);
    }
    
    public long binarySearch(long left, long right) {     
        while (left < right) {
            long mid = (left + right) / 2;
            
            if (isPossible(mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public boolean isPossible(long target) {
        long n = 0;
        for (int t : sortedTimes) {
            n += target / t;
            if (n >= N) return true;
        }
        return false;   
    }
}











/*
import java.util.*;

심사해야 하는 사람 수: n
심사에 걸리는 시간: T(x)
모든 심사 완료 시간: R

n <= R/T(1) + R/T(2) ... R/T(T.length) 라면 R 시간 내에 모든 심사가 가능하다.
따라서 isPossible 함수는 위와 같이 구현한다.

R 의 boundary 는
T(min) x (n / T.length) <= R <= T(max) * (n / T.length)
-> 가장 빠르게 걸리는 심사대가 T.length 개 있을 때 검사시간보다 느리고, 
가장 느리게 걸리는 심사대가 T.length 개 있을 때 검사시간보다 빠르다.



심사관 수를 k, 각 심사관의 처리 시간을 T1, T2, ..., Tk라고 하자.

시간 R이 주어졌을 때, i번째 심사관이 처리할 수 있는 인원 수는 ⌊R / Ti⌋명이다.

따라서 R분 안에 처리 가능한 전체 인원 수는

Σ⌊R / Ti⌋

이다.

그러므로 다음 조건을 만족하면 R분 안에 n명을 모두 심사할 수 있다.

Σ⌊R / Ti⌋ >= n

우리는 이 조건을 만족하는 최소 R을 찾아야 하므로,
R의 범위를 이분탐색한다.

초기 범위는

1 <= R <= Tmin × n

으로 둘 수 있다.

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long right = (long) times[0] * n;
        
        return binarySearch(1, right, n, times);
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

*/