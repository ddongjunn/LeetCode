class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean isBlocked = false;
        StringBuilder sb = new StringBuilder();

        for (String str : source) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (isBlocked) {
                    if (ch == '*' && str.charAt(i + 1) == '/') {
                        isBlocked = false;
                        i++;
                    } 
                    continue;
                } else {
                    if (ch == '/') {
                        if (i + 1 < str.length() && str.charAt(i + 1) == '*') {
                           isBlocked = true;
                           i++;
                           continue;
                        } else if (i + 1 < str.length() && str.charAt(i + 1) == '/') {
                            break;
                        }
                    }
                }

                if (!isBlocked) {
                    sb.append(ch);
                }
            }

            if (!isBlocked && sb.length() > 0) {
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }

        return ans;
    }
}