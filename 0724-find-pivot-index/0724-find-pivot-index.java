class Solution {
    public int pivotIndex(int[] nums) {
		int total = Arrays.stream(nums).sum();
		
		int leftSum = 0;
		for(int i=0; i<nums.length; i++) {
			if(leftSum == total - leftSum - nums[i]) {
				return i;
			}
			leftSum += nums[i];
		}
		
		return -1;
    }
}