class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String oper : operations) {
            if ("C".equals(oper)) {
                stack.pop();
            } else if ("D".equals(oper)) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(oper)) {
                int first = stack.pop();
                int second = stack.peek() + first;
                stack.push(first);
                stack.push(second);
            } else {
                stack.push(Integer.parseInt(oper));
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}