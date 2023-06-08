class Solution {
    public String reverseVowels(String word) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
		int start = 0;
		int end = word.length() - 1;
		
		char[] ch = word.toCharArray();
		
		while (start < end) {
            char startChar = ch[start];
            char endChar = ch[end];

            if (!vowels.contains(startChar)) {
                start++;
            } else if (!vowels.contains(endChar)) {
                end--;
            } else {
                swap(ch, start, end);
                start++;
                end--;
            }
        }
		return new String(ch);
    }
    
    public void swap(char[] ch, int x, int y) {
		char temp = ch[x];
		ch[x] = ch[y];
		ch[y] = temp;
	}
}