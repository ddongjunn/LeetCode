import java.util.Map;
import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[101];
        
        int result = 0;
        for(int num : nums) {
            result += cnt[num]++;    
        }
        return result;
    }
}