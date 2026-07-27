class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        boolean isInsert = false;

        int start = newInterval[0];
        int end = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextEnd < start) {
                answer.add(new int[]{nextStart, nextEnd});
            } else if (end < nextStart) {
                if (!isInsert) {
                    answer.add(new int[]{start, end});
                    isInsert = true;
                }
                answer.add(new int[]{nextStart, nextEnd});
            } else {
                start = Math.min(start, nextStart);
                end = Math.max(end, nextEnd);
            }
        }

        if (!isInsert) {
            answer.add(new int[]{start, end});
        }
        return answer.toArray(int[][]::new);
    }
}