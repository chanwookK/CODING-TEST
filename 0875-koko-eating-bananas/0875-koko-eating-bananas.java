class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > right) right = piles[i];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (possibleEat(mid, piles, h)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean possibleEat(int k, int[] piles, int limit) {
        int time = 0;
        for (int pile : piles) {
            time += pile / k;
            if (pile % k != 0) time++;
        }

        if (limit < time) return false;
        return true;
    }
}