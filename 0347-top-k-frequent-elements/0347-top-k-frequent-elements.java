class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        for (int key : map.keySet()) {
            heap.add(key);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = heap.poll();
        }
        
        return answer;
    }
}