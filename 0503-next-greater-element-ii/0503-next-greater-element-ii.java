class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        var ans = new int[n];
        Arrays.fill(ans, -1);

        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            
            if (i < n) {
                stack.push(i % n);
            }
        }
        return ans;
    }
}