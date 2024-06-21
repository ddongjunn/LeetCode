class Solution {
    public int findNonMinOrMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        for(int num : nums) {
            if(num != max && num != min) {
                return num;
            }
        }
        
        return -1;
    }
}