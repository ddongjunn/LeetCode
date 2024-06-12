import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList();        
        
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if(left < nums.length && nums[left] == target) {
            for(int i = left; i < nums.length && nums[i] == target; i++) {
                result.add(i);
            }
        }
        
        return result;
    }
}