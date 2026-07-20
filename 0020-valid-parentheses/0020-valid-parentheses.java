class Solution {
    public boolean isValid(String s) {
        var map = Map.of('(',')','[',']','{','}');
        var stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (map.get(stack.pop()) != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}