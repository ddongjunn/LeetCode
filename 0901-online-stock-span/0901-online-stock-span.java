class StockSpanner {
    int cur = 0;
    final List<Integer> list = new ArrayList<Integer>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int cnt = 0;
        list.add(price);
        for (int i = cur; 0 <= i; i--) {
            if (list.get(i) <= price){
                cnt++;
            } else {
                break;
            }
        }
        cur++;
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */