class Solution {
    public int longestSubarray(int[] nums) {
		int start = 0;
		int end = 0;
		int zeros = 0;
		int max = 0;
		while(end < nums.length) {
			if(nums[end] == 0) {
				zeros++;
			}
			
			if(zeros > 1) {
				if(nums[start] == 0) {
					zeros--;
				}
				start++;
			}else {
				max = Math.max(end-start, max);
			}
			end++;
		}
		return max;
    }
}