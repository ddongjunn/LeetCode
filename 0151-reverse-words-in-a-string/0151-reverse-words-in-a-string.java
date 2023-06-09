class Solution {
    public String reverseWords(String s) {
	        String[] str = s.trim().split(" ");

	        StringBuilder result = new StringBuilder();
	        
	        for(int i=str.length-1; i>=0; i--) {
	        	if(!str[i].trim().equals("")) {
	        		result.append(str[i]);
	        		if(i != 0) {
	        			result.append(" ");
	        		}
	        	}
	        }
	        
	        result.setLength(result.length());
	        
	        return result.toString();
	}
}