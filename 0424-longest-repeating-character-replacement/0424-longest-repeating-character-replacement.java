class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, answer = 0, max = 0;
        int[] cnt = new int[26];

        while (right < s.length()) {
            cnt[s.charAt(right) - 'A']++;
            max = Math.max(max, cnt[s.charAt(right) - 'A']);
            right++;

            if (k < (right - left) - max) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            
            answer = Math.max(answer, right - left);
        }

        return answer;
    }
}