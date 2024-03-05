class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> table = new HashMap<>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};
        
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(!table.containsKey(ch)){
                stack.push(ch);
                continue;
            } 
            
            if(stack.isEmpty() || table.get(ch) != stack.pop()){
                return false;
            }
        }
        
        return stack.size() == 0;
    }
}