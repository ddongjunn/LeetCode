class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Character[] c = s.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new);
        // Arrays.sort(c, new Comparator<Character>() {
        //     public int compare(Character c1, Character c2) {
        //         return Integer.compare(map.get(c2), map.get(c1));
        //     }
        // });
        
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());

        StringBuilder sortedString = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            for (int i = 0; i < map.get(c); i++) {
                sortedString.append(c);
            }
        }
        
        return sortedString.toString();
    }
}