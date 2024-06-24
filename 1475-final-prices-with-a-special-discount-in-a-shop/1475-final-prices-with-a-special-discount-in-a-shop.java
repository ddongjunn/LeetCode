class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];            
        Deque<Integer> stack = new ArrayDeque();
        
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                ans[idx] = prices[idx] - prices[i];
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = prices[idx];
        }
        
        return ans;
    }
}