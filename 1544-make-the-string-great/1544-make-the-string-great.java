class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int len = sb.length() - 1;
            if (len >= 0 && Character.toLowerCase(sb.charAt(len)) == Character.toLowerCase(s.charAt(i)) && sb.charAt(len) != s.charAt(i)) {
                sb.deleteCharAt(len);
            } else {
                sb.append(s.charAt(i));    
            }
        }
        return sb.toString();
    }
}

/**
동일한 대문자 & 소문자, 소문자 & 대문자 조합인 경우 삭제
 */