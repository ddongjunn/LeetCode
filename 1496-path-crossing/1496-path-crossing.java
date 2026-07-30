class Solution {
    public boolean isPathCrossing(String path) {
        int[][] dirs = {
            {0, 1}, //north
            {0, -1},//south
            {1, 0}, //east
            {-1, 0} //west
        };
        
        int nx = 0;
        int ny = 0;

        Set<Pos> visited = new HashSet<>();
        visited.add(new Pos(nx, ny));

        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                nx += dirs[0][0];    
                ny += dirs[0][1];
            } else if (ch == 'S') {
                nx += dirs[1][0];    
                ny += dirs[1][1];
            } else if (ch == 'E') {
                nx += dirs[2][0];    
                ny += dirs[2][1];
            } else {
                nx += dirs[3][0];    
                ny += dirs[3][1];
            }

            if (!visited.add(new Pos(nx, ny))) {
                return true;
            }
        }
        return false;
    }
}

record Pos (int x, int y) {}