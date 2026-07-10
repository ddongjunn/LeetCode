class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;

        int[] result = new int[nums.length];
        while (left <= right) {
            int ln = nums[left] * nums[left];
            int rn = nums[right] * nums[right];

            if (ln < rn) {
                result[index--] = rn;
                right--;
            } else {
                result[index--] = ln;
                left++;
            }
        }
        return result;
    }
}