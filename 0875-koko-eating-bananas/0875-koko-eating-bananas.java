class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int speed = left + (right - left) / 2;

            int time = 0;
            for (int i = 0; i < piles.length; i++) {
                time += (int) Math.ceil((double) piles[i] / speed);
            }

            if (h >= time) {
                right = speed;
            } else {
                left = speed + 1;
            }
        }
        return left;
    }
}