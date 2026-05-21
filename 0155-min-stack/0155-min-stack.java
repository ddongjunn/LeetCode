class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
            return;
        }

        if (!minStack.isEmpty() && minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!minStack.isEmpty() && minStack.peek().equals(stack.pop())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */