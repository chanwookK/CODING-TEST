import java.util.*;

class Solution {
    public List<Integer> rockDistances = new ArrayList<>();
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        for (int i = 0; i < rocks.length + 1; i++) {
            if (i == 0) {
                rockDistances.add(rocks[i]);
            }
            else if (i == rocks.length) {
                rockDistances.add(distance - rocks[i - 1]);
            }
            else {
                rockDistances.add(rocks[i] - rocks[i - 1]);
            }
        }
        
        return binarySearch(0, distance, n);
    }
    
    public int binarySearch(int left, int right, int n) {
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, n)) {
                left = mid + 1;
                answer = mid;
            }
            else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int d, int n) {
        List<Integer> tempRockDistances = new ArrayList<>(rockDistances);
        
        int removeCount = 0;
        for (int i = 0; i < tempRockDistances.size(); i++) {
            if (i == tempRockDistances.size() - 1) {
                if (tempRockDistances.get(i) < d) {
                    if (i - 1 < 0) return false;
                    tempRockDistances.set(i, tempRockDistances.get(i) + tempRockDistances.get(i - 1));
                    tempRockDistances.remove(i - 1);
                    removeCount++;
                    i = tempRockDistances.size() - 2;
                }
            }
            else if (tempRockDistances.get(i) < d) {
                tempRockDistances.set(i, tempRockDistances.get(i) + tempRockDistances.get(i+1));
                tempRockDistances.remove(i + 1);
                removeCount++;
                i--;
            }
        }
        
        if (removeCount > n) return false;
        return true;
    }
}