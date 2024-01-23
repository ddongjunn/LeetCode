import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            
            String key = String.valueOf(ch);
            if(!result.containsKey(key)){
                result.put(key, new ArrayList<>());
            }
            
            result.get(key).add(str);
        }
        
        return new ArrayList<>(result.values());
    }
}