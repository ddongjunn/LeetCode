class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        
        Deque<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            
            cnt++;
            q.offer(i);
            isVisited[i] = true;
            while (!q.isEmpty()) {
                int city = q.poll();

                for (int j = 0; j < isConnected[city].length; j++) {
                    if (isConnected[city][j] == 1 && !isVisited[j]) {
                        q.offer(j);
                        isVisited[j] = true;
                    }
                }
            }
        }
        return cnt;
    }
}