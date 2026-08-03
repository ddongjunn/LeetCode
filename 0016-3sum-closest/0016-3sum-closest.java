class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //target과 제일 가까운 sum
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[left] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return closestSum;
    }
}