class Solution {
    public int minLength(String s) {
        //완탐
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "").replace("CD", "");
        }
        return s.length();
    }
}

/*
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
 */