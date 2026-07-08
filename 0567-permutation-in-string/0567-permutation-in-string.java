class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int[] target = new int[26];
        int[] window = new int[26];


        for (int i = 0; i < s1.length(); i++) {
            target[s1.charAt(i) - 'a']++;
        }

        while (right < s2.length()) {
            window[s2.charAt(right) - 'a']++;
            right++;

            if (right - left > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }   

            if (Arrays.equals(target, window)) {
                return true;
            }
        }
        return false;
    }
}