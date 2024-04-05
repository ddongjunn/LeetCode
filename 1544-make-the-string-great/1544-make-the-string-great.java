class Solution {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && 
               (Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(stack.peek()))){
                if(s.charAt(i) != stack.peek()){
                    System.out.println(s.charAt(i) + " " +i);
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
}