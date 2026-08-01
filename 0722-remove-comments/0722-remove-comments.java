class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        boolean isBlock = false;

        for (String cmd : source) {
            for (int i = 0; i < cmd.length(); i++) {
                char curr = cmd.charAt(i);
                char next = i + 1 < cmd.length() 
                        ? cmd.charAt(i + 1) 
                        : ' ';

                if (isBlock) {
                    if (curr == '*' && next == '/') {
                        isBlock = false;
                        i++;
                    }
                    continue;
                }

                if (curr == '/' && next == '*') {
                    isBlock = true;
                    i++;
                    continue;
                }

                if (curr == '/' && next == '/') {
                    break;
                }

                sb.append(curr);
            }

            if (!isBlock && sb.length() > 0) {
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ans;
    }
}