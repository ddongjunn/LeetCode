class Solution {
    public int findKthLargest(int[] nums, int k) {
        int targetIdx = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIdx = partition(nums, left, right);

            if (pivotIdx == targetIdx) {
                return nums[pivotIdx];
            } else if (pivotIdx < targetIdx) {
                left = pivotIdx + 1;
            } else {
                right = pivotIdx - 1;
            }
        }

        throw new IllegalArgumentException();
    }

    public int partition (int[] nums, int left, int right) {
        int pivot = nums[right];
        int smallIdx = left;

        for (int current = left; current < right; current++) {
            if (nums[current] < pivot) {
                swap(nums, smallIdx, current);
                smallIdx++;
            }
        }
        swap (nums, smallIdx, right);
        return smallIdx;
    }

    public void swap (int[] nums, int x, int y) {
        int swap = nums[x];
        nums[x] = nums[y];
        nums[y] = swap;
    }
}