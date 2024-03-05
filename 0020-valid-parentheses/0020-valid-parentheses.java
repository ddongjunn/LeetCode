class Solution {
    
    private static final Map<Character, Character> PAIR_MAPPING = Map.of(')','(','}','{',']','[');
    
    public boolean isValid(String s) {    
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()){
            if(!PAIR_MAPPING.containsKey(ch)){
                stack.push(ch);
                continue;
            }    
            
            if(stack.isEmpty() || PAIR_MAPPING.get(ch) != stack.pop()){
                return false;
            }
        }
        
        return stack.isEmpty();
    }       
}