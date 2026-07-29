class Solution {
    private final int[] DX = {1, 0, -1, 0};
    private final int[] DY = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] isVisited = new boolean[rows][cols];
        int answer = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isVisited[row][col] || grid[row][col] == '0') continue;
                bfs(row, col, grid, isVisited);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] isVisited) {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(row, col));

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = pos.x() + DX[dir];
                int ny = pos.y() + DY[dir];

                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
                if (isVisited[nx][ny] || grid[nx][ny] == '0') continue;

                isVisited[nx][ny] = true;
                q.offer(new Pos(nx, ny));
            }
        }
    }
}

record Pos (int x, int y) {}