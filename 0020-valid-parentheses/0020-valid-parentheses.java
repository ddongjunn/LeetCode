class Solution {
    ArrayDeque<Character> stack = new ArrayDeque<>();

    public boolean isValid(String s) {
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                stack.push(ch[i]);
                continue;
            }

            if (isMatched(ch[i])) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }

    private boolean isMatched(char bracket) {
        var map = Map.of(')','(','}','{',']','[');
        char pair = map.get(bracket);
        return (!stack.isEmpty() && stack.peek() == pair);
    }
}

