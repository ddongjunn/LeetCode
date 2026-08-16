class Solution {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, new ArrayList<>(), new boolean[n + 1]);
        return result;
    }

    public void dfs (int n, int k, int idx, List<Integer> list, boolean[] isUsed) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            list.add(i);
            dfs(n, k, i + 1, list, isUsed);
            list.remove(list.size() - 1);
            isUsed[i] = false;
        }   
    }
}

/*
n=4, k=2
1부터 4까지 숫자중 2개의 숫자 조합 중복 X
*/