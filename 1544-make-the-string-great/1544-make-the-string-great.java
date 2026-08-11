class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int len = sb.length() - 1;

            if (len >= 0 && Character.isUpperCase(sb.charAt(len)) && Character.isLowerCase(s.charAt(i))) {
                if (Character.toLowerCase(sb.charAt(len)) == s.charAt(i)) {
                    sb.deleteCharAt(len);
                    continue;
                }
            } else if (len >= 0 && Character.isLowerCase(sb.charAt(len)) && Character.isUpperCase(s.charAt(i))) {
                if (Character.toUpperCase(sb.charAt(len)) == s.charAt(i)) {
                    sb.deleteCharAt(len);
                    continue;
                }   
            } 
            
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

/**
동일한 대문자 & 소문자, 소문자 & 대문자 조합인 경우 삭제
 */