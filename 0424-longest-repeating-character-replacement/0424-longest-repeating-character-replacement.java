class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int left = 0;
        int maxFreq = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            cnt[idx]++;

            maxFreq = Math.max(maxFreq, cnt[idx]);
            while ((right - left + 1) - maxFreq > k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }

            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}