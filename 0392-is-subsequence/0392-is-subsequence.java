class Solution {
    public boolean isSubsequence(String s, String t) {
        int answer = 0;
        int left = 0;
        int right = t.length();
        while (left < right && answer < s.length()) {
            if (t.charAt(left) == s.charAt(answer)) {
                answer++;
            }
            left++;
        }
        return answer == s.length();
    }
}