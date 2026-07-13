class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int answer = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int cur = num;
            int len = 1;
            while (set.contains(cur + 1)) {
                cur++;
                len++;
            }

            answer = Math.max(answer, len);
        }
        return answer;
    }
}