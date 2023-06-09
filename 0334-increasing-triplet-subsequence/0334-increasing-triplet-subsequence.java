class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] <= n) {
        		n = nums[i];
        	}else if(nums[i] <= n2) {
        		n2 = nums[i];
        	}else {
        		return true;
        	}
        }
        return false;
    }
}