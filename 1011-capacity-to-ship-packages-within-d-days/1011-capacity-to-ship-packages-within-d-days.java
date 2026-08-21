class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int d = 1;
            int w = 0;
            for (int weight : weights) {
                w += weight;
                if (mid < w) {
                    d++;
                    w = weight;
                }
            }

            if (d <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
left == max 용량
right == sum
 */