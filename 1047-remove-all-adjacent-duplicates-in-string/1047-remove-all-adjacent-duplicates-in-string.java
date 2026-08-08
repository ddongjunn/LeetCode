class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int lastIndex = sb.length() - 1;
            
            if (lastIndex >= 0 && sb.charAt(lastIndex) == ch) {
                sb.deleteCharAt(lastIndex);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}