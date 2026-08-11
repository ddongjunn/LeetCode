class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int top = sb.length() - 1;

            if (top >= 0 && sb.charAt(top) == ch) {
                sb.setLength(top);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}