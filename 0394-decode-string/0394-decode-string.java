class Solution {
    public String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if(Character.isDigit(ch)) {
        		int cnt = 0;
        		while(Character.isDigit(s.charAt(i))) {
        			cnt = 10 * cnt + (s.charAt(i) - '0');
        			i++;
        		}
        		i--;
        		countStack.push(cnt);
        	}else if (ch == '[') {
        		resStack.push(result.toString());
        		result.setLength(0);
        	}else if (ch == ']') {
        		StringBuilder temp = new StringBuilder(resStack.pop());
        		int cnt = countStack.pop();
        		for(int j=0; j<cnt; j++) {
        			temp.append(result);
        		}
        		result = temp;
        	}else {
        		result.append(s.charAt(i));
        	}
        }		

		return result.toString();
	}
}