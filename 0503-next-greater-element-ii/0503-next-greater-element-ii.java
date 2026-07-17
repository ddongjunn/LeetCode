class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (i + j) % n;
                if (nums[idx] > nums[i]) {
                    ans[i] = nums[idx];
                    break;
                }
            }
        }
        return ans;
    }
}