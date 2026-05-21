class Solution {
    Map<Character, Character> map = Map.of(')','(','}','{',']','[');

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                stack.push(ch[i]);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char open = stack.pop();
            char close = ch[i];
            if (isMatched(open, close)) {
                continue;
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }

    private boolean isMatched(char open, char close) {
        return open == map.get(close);
    }
}

