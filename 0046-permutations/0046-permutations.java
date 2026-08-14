class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    public void dfs(int[] nums, List<Integer> curr, List<List<Integer>> result, boolean[] isUsed) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            curr.add(nums[i]);
            dfs(nums, curr, result, isUsed);
            isUsed[i] = false;
            curr.remove(curr.size() - 1);
        }
        return;
    }
}