/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if(s == null || s.isEmpty()) {
            return new NestedInteger();
        }
        
        int sign = 1;
        Deque<NestedInteger> stack = new ArrayDeque();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == '[') {
                stack.push(new NestedInteger());
            } else if(ch == ']' && stack.size() > 1) {
                NestedInteger n = stack.pop();
                stack.peek().add(n);
            } else if(ch == '-') {
                sign = -1;
            } else if(Character.isDigit(ch)) {
                int num = ch - '0'; 
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num *= sign;
                if(stack.isEmpty()) {
                    stack.push(new NestedInteger(num));
                } else {
                    stack.peek().add(new NestedInteger(num));
                }
                sign = 1;
            }
        }
        
        return stack.isEmpty() ? new NestedInteger() : stack.pop();
    }
}