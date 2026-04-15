class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (words[i].equals(target)) {
                int distance = Math.min(
                    Math.abs(i - startIndex),
                    n - Math.abs(i - startIndex)
                );
                answer = Math.min(answer, distance);
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}