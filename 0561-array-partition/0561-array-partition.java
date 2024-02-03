import java.util.*;

class Solution {
    public int arrayPairSum(int[] nums) {
        ArrayList<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);
        
        int sum = 0;
        for(int n : nums){
            pair.add(n);
            
            if(pair.size() == 2){
                sum += Collections.min(pair);
                pair.clear();
            }
        }
        
        return sum;
    }
}