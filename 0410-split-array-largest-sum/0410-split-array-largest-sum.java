import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(condition(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }            
        }
        return left;
    }
    
    public boolean condition(int[] nums, int k, int maxSum) {
        int subArrays = 1;
        int currentSum = 0;
        
        for(int num : nums) {
            if(currentSum + num > maxSum) {
                subArrays++;
                currentSum = 0;
            }
            currentSum += num;
        }
        return subArrays <= k;
    }
}