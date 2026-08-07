class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (goal.contains(s.substring(i) + s.substring(0, i))) {
                return true;
            }
        }

        return false;
    }
}