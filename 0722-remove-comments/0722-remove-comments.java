class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean isBlock = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length(); j++) {
                char current = source[i].charAt(j);
                char next = j + 1 < source[i].length()
                                ? source[i].charAt(j + 1)
                                : '\0';
                //end block
                if (isBlock) {
                    if (current == '*' && next == '/') {
                        isBlock = false;
                        j++;
                    }
                    continue;
                }

                //start block //
                if (current == '/' && next == '/') {
                    break;
                } 

                //start block /*
                if (current == '/' && next == '*') {
                    isBlock = true;
                    j++;
                    continue;
                }

                sb.append(current);
            }

            if (!isBlock && sb.length() > 0) {
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ans;
    }
}