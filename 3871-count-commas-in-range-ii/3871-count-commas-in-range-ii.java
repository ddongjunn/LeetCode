class Solution {
    public long countCommas(long n) {
        if (n < 1000) return 0;

        long cnt = 0;
        long m = 1000;
        long num = n;
        while (num >= 1000) {
            cnt += n - m + 1;
            num /= 1000;
            m = m * 1000;
        }

        return cnt;
    }
}