class StockSpanner {
    ArrayDeque<Pair> stack = new ArrayDeque<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price() <= price) {
            span += stack.pop().span();
        }
        
        stack.push(new Pair(price, span));
        return span;
    }

}

record Pair(int price, int span){}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */