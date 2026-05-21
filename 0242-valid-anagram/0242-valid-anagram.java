class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int idx[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            idx[s.charAt(i) - 'a']++;
            idx[t.charAt(i) - 'a']--;
        }

        return Arrays.stream(idx).allMatch(i -> i == 0);
    }
}