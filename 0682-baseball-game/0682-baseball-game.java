class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            
            if ("C".equals(op)) {
                stack.pop();
            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(op)) {
                int top = stack.pop();
                int half = stack.peek();
                stack.push(top);
                stack.push(top + half);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
                
        int result = 0;
        for (int n : stack) {
            result += n;
        }
        return result;
    }
}