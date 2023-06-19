class Solution {
    public boolean closeStrings(String word1, String word2) {
		if(word1.length() != word2.length()) {
			return false;
		}
		
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
        
		for(char ch : word1.toCharArray()) {
        	map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : word2.toCharArray()) {
        	map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : word1.toCharArray()) {
        	if(!map2.containsKey(ch)) {
        		return false;
        	}
        }
        
        for(char ch : word2.toCharArray()) {
        	if(!map1.containsKey(ch)) {
        		return false;
        	}
        }
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
        	Character key = entry.getKey();
        	Integer value = entry.getValue();
        	list1.add(value);
        	list2.add(map2.get(key));
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        for(int i=0; i<list1.size(); i++) {
        	if(list1.get(i).compareTo(list2.get(i)) != 0){
        		return false;
        	}
        }
        
        return true;
    }
}