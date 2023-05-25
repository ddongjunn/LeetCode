class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
		char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();

        int cur1 = 0;
        int cur2 = 0;
        while(true) {
        	
        	if(cur1 != ch1.length) {
        		sb.append(ch1[cur1++]);
        	}
        	
        	if(cur2 != ch2.length) {
        		sb.append(ch2[cur2++]);
        	}
        	
        	if((cur1 == ch1.length) && (cur2 == ch2.length)){
        		break;
        	}
        }
        
        return sb.toString();
    }
}