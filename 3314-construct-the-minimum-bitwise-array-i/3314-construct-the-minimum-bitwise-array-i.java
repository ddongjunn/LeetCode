class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            ans[i] = -1;
            int target = nums.get(i);
            if ((target & 1) == 0) {
                continue;
            }

            for (int j = 0; j < target; j++) {
                if ((j | (j + 1)) == target) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}