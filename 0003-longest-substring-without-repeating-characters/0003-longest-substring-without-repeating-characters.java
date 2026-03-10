class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int len = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);

            len = Math.max(len, set.size());
        }
        return len;
    }
}