class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 정렬된 지점 찾기
            if (nums[left] <= nums[mid]) {
                // left ~ mid 사이 target이 있으면 right 버리기
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;                   
                } else {
                    left = mid + 1;
                }
            } else { // mid ~ right 사이 target이 있으면 left 버리기
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}