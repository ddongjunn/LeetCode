class Solution {
    public String removeStars(String s) {
		Stack<Character> st = new Stack<Character>();
		Stack<Character> st2 = new Stack<Character>();
		
		for(int i=s.length()-1; i>=0; i--) {
			st.push(s.charAt(i));
		}
		
		while(!st.isEmpty()) {
			if(st.peek() != '*') {
				st2.push(st.pop());
				continue;
			}
			st.pop();
			st2.pop();
		}
		
		while(!st2.isEmpty()) {
			st.push(st2.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		return sb.toString();	
	}
}