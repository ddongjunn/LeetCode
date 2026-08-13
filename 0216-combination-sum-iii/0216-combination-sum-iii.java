class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, 1, 0, list, result);
        return result;
    }

    public void dfs(int k, int target, int idx, int sum, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            if (sum == target) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = idx; i < 10; i++) {
            list.add(i);
            dfs(k, target, i + 1, sum + i, list, result);
            list.remove(list.size() - 1);
        }        
    }
}