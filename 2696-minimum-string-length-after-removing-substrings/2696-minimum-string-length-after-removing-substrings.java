class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() &&
                ((stack.peek() == 'A' && ch == 'B') || (stack.peek() == 'C' && ch == 'D'))) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
        }
        return stack.size();
    }
}
