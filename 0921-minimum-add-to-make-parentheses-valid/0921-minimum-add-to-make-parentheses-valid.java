class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && (stack.peek() == '(' && ch == ')')){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        return stack.size();
    }
}