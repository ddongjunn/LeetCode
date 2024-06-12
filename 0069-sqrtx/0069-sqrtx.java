class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = (long) x + 1;
        
        while(left < right) {
            long mid = left + (right - left) / 2;
            if(mid * mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left - 1;
    }
}