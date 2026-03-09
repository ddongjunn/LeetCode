class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                maxCnt = Math.max(cnt, maxCnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return Math.max(cnt, maxCnt);
    }
}