class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder first = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int lastIdx = first.length() - 1;
            
            if (lastIdx >= 0 && ch == '#') {
                first.deleteCharAt(lastIdx);
            } else if (lastIdx < 0 && ch == '#') {
                continue;
            } else {
                first.append(ch);
            }
        }

        StringBuilder second = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int lastIdx = second.length() - 1;
            
            if (lastIdx >= 0 && ch == '#') {
                second.deleteCharAt(lastIdx);
            } else if (lastIdx < 0 && ch == '#') {
                continue;
            } else {
                second.append(ch);
            }
        }

        return first.toString().equals(second.toString());
    }
}