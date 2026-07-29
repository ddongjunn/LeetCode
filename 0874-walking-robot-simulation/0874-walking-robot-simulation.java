class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Pos> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(new Pos(obstacle[0], obstacle[1]));
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int x = 0;
        int y = 0;
        int maxDistance = 0;
        for (int cmd : commands) {
            if (-1 == cmd) {
                dir = (dir + 1) % 4;
                continue;
            }

            if (-2 == cmd) {
                dir = (dir + 3) % 4;
                continue;
            }

            for (int step = 0; step < cmd; step++) {
                int nx = x + dirs[dir][0];
                int ny = y + dirs[dir][1];

                if (obstacleSet.contains(new Pos(nx, ny))) {
                    break;
                }

                x = nx;
                y = ny;
            }

            maxDistance = Math.max(maxDistance, (int) ((Math.pow(x, 2)) + (Math.pow(y, 2))));
        }
        return maxDistance;
    }
}

record Pos (int x, int y) {}