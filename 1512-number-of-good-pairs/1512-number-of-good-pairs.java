import java.util.Map;
import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int answer = 0;
        for(int count : map.values()) {
            if(count > 1) {
                answer += count * (count - 1) / 2;
            }
        }
        
        return answer;
    }
}