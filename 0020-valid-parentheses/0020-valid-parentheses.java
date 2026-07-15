class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch ==  '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty() || pair.get(ch) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}