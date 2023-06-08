class Solution {
    public String reverseVowels(String word) {
		Set<Character> vowel = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
		int start = 0;
		int end = word.length() - 1;
		boolean startFlag = false;
		boolean endFlag = false;
		
		char[] ch = word.toCharArray();
		
		while(start < end) {
			if(!vowel.contains(ch[start])) {	
				start++;
			}else {
				startFlag = true;
			}
			
			if(!vowel.contains(ch[end])) {
				end--;
			}else {
				endFlag = true;
			}
			
			if(startFlag && endFlag) {
				swap(ch, start, end);
				start++;
				end--;
				startFlag = false;
				endFlag = false;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ch.length; i++) {
			sb.append(ch[i]);
		}
		return sb.toString();
    }
	
	public void swap(char[] ch, int x, int y) {
		char c = ch[x];
		ch[x] = ch[y];
		ch[y] = c;
	}
}