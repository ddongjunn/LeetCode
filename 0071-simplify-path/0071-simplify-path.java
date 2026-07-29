class Solution {
    public String simplifyPath(String path) {
        var stack = new ArrayDeque<String>();
        for (String s : path.split("/")) {

            if (s.trim().isBlank()) {
                continue;
            }

            if (!stack.isEmpty() && "..".equals(s)) {
                stack.pop();
                continue;
            }

            if ("..".equals(s) || ".".equals(s)) {
                continue;
            }

            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}