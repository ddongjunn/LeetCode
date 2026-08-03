class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int k = left + (right - left) / 2;

            int eatingTime = 0;
            for (int i = 0; i < piles.length; i++) {
                eatingTime += piles[i] / k;
                eatingTime += piles[i] % k != 0 ? 1 : 0;
            }

            if (eatingTime <= h) { // eatingTime이 같거나 작으면 오른쪽 범위 제거
                right = k;
            } else { // eatingTime이 더 크다면 k 증가
                left = k + 1;
            }
        }

        return left;
    }
}