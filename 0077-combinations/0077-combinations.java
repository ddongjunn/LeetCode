class Solution {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, new ArrayList<>());
        return result;
    }

    public void dfs (int n, int k, int idx, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }   
    }
}

/*
n=4, k=2
1부터 4까지 숫자중 2개의 숫자 조합 중복 X
*/