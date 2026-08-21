class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int hours = 0;
            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid != 0) hours++;
            }

            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/**
최소 k == 1시간에 먹을 수 있는 개수
 */