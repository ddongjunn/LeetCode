class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        
        for(int[] arr : grid) {
            for(int num : arr) {
                if(num < 0) {
                    result++;
                }
            }
        }
        
        return result;
    }
}