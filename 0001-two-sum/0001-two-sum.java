class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];

            if (map.containsKey(num)) {
                return new int[]{i, map.get(num)};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}