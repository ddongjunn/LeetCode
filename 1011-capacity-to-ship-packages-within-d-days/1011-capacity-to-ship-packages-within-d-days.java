class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            int countDay = 1;
            for (int i = 0; i < weights.length; i++) {
                if (count + weights[i] > mid) {
                    count = 0;
                    countDay++;
                }

                count += weights[i];
            }
            
            if (countDay <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/*
    left -> 최소 후보 (가장 무거운 상자)
    right -> 최대 후보

    days 안에 선박의 최소 적재 용량
    - 정렬 X
*/