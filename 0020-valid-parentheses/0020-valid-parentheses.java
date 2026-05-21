class Solution {
    private final Map<Character, Character> map = Map.of(')','(','}','{',']','[');

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            char cur = ch[i];
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char open = stack.pop();
            char close = cur;
            if (!isMatched(open, close)) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }

    private boolean isMatched(char open, char close) {
        return open == map.get(close);
    }
}

