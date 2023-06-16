class Solution {
    public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			int n = map.getOrDefault(i, 0);
			if(n == 0) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i)+1);
			}	
		}
		
		Set<Integer> set = new HashSet<>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(set.contains(entry.getValue())) {
				return false;
			}
			set.add(entry.getValue());
		}
		
		return true;
	}
}