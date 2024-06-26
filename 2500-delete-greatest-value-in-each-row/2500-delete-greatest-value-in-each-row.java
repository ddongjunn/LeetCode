class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int sum = 0;
        for(int j = 0; j < n; j++) {
            int mx = Integer.MIN_VALUE;
            for(int i = 0; i < m; i++) {
                mx = Math.max(mx, grid[i][j]);
            }
            sum += mx;   
        }
        
        return sum;
    }
}