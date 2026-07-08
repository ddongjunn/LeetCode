class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int answer = 0;

        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char current = s.charAt(right);
            char prev = s.charAt(left);

            if (set.contains(current)) {
                set.remove(prev);
                left++;
            } else {
                set.add(current);
                right++;
                answer = Math.max(answer, right - left);
            }
        }
        return answer;
    }
}