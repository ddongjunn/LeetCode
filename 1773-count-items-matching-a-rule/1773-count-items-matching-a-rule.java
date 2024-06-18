import java.util.Map;
import java.util.HashMap;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;
        Map<String, Integer> type = new HashMap();
        type.put("type", 0);
        type.put("color", 1);
        type.put("name", 2);
        for(List<String> item : items) {
            if(item.get(type.get(ruleKey)).equals(ruleValue)) {
                result++;
            }
        }
        return result;
    }
}