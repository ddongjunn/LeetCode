class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for(int j = 0; j < mat[0].length && mat[i][j] == 1; j++) {
                cnt++;
            }
            map.put(i, cnt);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a - b : map.get(a) - map.get(b));
        heap.addAll(map.keySet());

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        
        return ans;
    }
}