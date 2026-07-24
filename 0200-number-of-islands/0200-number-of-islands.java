class Solution {
    private final int[] DR = {1, 0, -1, 0};
    private final int[] DC = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length; 
        int ans = 0;

        boolean[][] isVisited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '0' || isVisited[row][col]) {
                    continue;
                }

                ans++;
                bfs(grid, isVisited, row, col);
            }
        }
        return ans;
    }

    private void bfs (char[][] grid, boolean[][] isVisited, int row, int col) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(row, col));
        isVisited[row][col] = true;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            int x = current.x();
            int y = current.y();

            for (int dir = 0; dir < DR.length; dir++) {
                int nx = x + DR[dir];
                int ny = y + DC[dir];

                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                    continue;
                }

                if (isVisited[nx][ny]) {
                    continue;
                }

                if (grid[nx][ny] == '0') {
                    continue;
                }

                isVisited[nx][ny] = true;
                queue.offer(new Pos(nx, ny));
            }
        }
    }
}

record Pos (int x, int y){}