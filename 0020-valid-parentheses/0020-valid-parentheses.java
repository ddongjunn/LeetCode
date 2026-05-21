class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            }

            if (ch[i] == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
            }

            if (ch[i] == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            }

            stack.push(ch[i]);
        }
        
        return stack.isEmpty();
    }
}