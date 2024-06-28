class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        
        Map<Integer, Integer> map = new HashMap();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());
        
        int sum = 0;
        int idx = 0;
        while(sum < len / 2) {
            sum += map.get(heap.poll());
            idx++;
        }
        
        return idx;
    }
}