class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(condition(nums, mid, target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }    
        return nums[left] == target ? left : -1;
    }
    
    public boolean condition(int[] nums, int idx, int target) {
        return nums[idx] >= target;
    }
}