class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int idx = 0;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        int[][] moved = new int[m][n];
        for (int i = 0; i < m * n; i++) {
            int newIdx = (i + k) % (m * n);
 
            int newRow = newIdx / n;
            int newCol = newIdx % n;
            moved[newRow][newCol] = arr[i];
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(moved[i][j]);
            }
            answer.add(list);
        }

        return answer;
    }
}