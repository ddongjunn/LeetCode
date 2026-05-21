class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            Integer prev = map.get(need);
            if (prev != null) {
                return new int[]{prev, i};
            }
            
            map.put(nums[i] , i);
        }

        throw new IllegalArgumentException();
    }
}