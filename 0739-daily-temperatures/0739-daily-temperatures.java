class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        var stack = new ArrayDeque<Integer>();
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                map.put(idx, i - idx);
            }   
            stack.push(i);
        }
        
        for (int i = 0; i < temperatures.length; i++) {
            ans[i] = map.getOrDefault(i, 0);
        }

        return ans;
    }
} 