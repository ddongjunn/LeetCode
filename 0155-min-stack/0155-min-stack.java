class MinStack {
    private final Deque<Node> stack = new ArrayDeque<>();
    private record Node(int val, int min) {}

    public MinStack() {
    }
    
    public void push(int value) {
        int min = stack.isEmpty() ? value : Math.min(value, stack.peek().min());
        stack.push(new Node(value, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val();
    }
    
    public int getMin() {
        return stack.peek().min();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */