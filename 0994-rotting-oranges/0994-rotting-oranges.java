class Solution {
    private final int[] DX = {1, 0, -1 ,0};
    private final int[] DY = {0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pos> queue = new ArrayDeque<>();
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new Pos(row, col));
                }
            }
        }

        int ans = bfs(grid, queue);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <cols; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return ans;    
    }

    private int bfs(int[][] grid, Queue<Pos> queue) {
        int ans = 0;
        boolean rottedThisMinute = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                Pos pos = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = pos.x() + DX[dir];
                    int ny = pos.y() + DY[dir];

                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                        continue;
                    }

                    if (grid[nx][ny] != 1) {
                        continue;
                    }

                    grid[nx][ny] = 2;
                    rottedThisMinute = true;
                    queue.offer(new Pos(nx, ny));
                }
            }

            if (rottedThisMinute) {
               ans++;
            }
        }

        return ans;
    }

    public record Pos(int x, int y){}
}
