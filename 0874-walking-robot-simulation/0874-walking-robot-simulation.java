class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(encode(obstacle[0], obstacle[1]));
        };

        int[][] dirs = {
            {0, 1}, //북
            {1, 0}, //동
            {0, -1}, //남
            {-1, 0} //서
        };
        
        int max = 0;
        int x = 0;
        int y = 0;
        int dir = 0;
        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else if (cmd == -2){
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if (set.contains(encode(nx, ny))) break;

                    x = nx;
                    y = ny;
                }
            }
            max = Math.max(max, (x * x) + (y * y));
        }
        return max;
    }

    private long encode(int x, int y) {
        return x * 100000L + y;
    }
}