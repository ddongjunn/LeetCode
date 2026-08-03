class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacle = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacle.add(obstacles[i][0] + ":" + obstacles[i][1]);
        }
        
        int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
        };

        int maxDistance = 0;
        int dir = 0;
        int x = 0;
        int y = 0;
        for (int cmd : commands) {

            if (-1 == cmd) {
                dir = (dir + 1) % 4;
            } else if (-2 == cmd) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    if (obstacle.contains(nx+":"+ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;
                    maxDistance = Math.max(maxDistance, (x * x) + (y * y));
                }
            }
        }
        return maxDistance;
    }
}