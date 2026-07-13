class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(entry);

            if (q.size() > k) {
                q.poll();
            }
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll().getKey();
        }
        return ans;
    }
}