class Solution {
    public boolean isValid(String s) {
        var map = Map.of('(',')','{','}','[',']');
        var stack = new ArrayDeque<Character>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (map.get(stack.peek()) != ch) {
                return false;
            }

            stack.pop();
        }
        return stack.isEmpty();
        
    }
}