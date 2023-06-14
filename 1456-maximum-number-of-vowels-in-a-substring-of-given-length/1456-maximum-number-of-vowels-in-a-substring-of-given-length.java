class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int windowVowels = 0;
		int maxVowels = 0;

        for(int i=0; i<k; i++) {
        	if(vowels.contains(s.charAt(i))) {
        		windowVowels++;
        	}
        }
        
        maxVowels = windowVowels;
        for(int i=k; i<s.length(); i++) {
        	if(vowels.contains(s.charAt(i-k))) {
        		windowVowels--;
        	}
        	
        	if(vowels.contains(s.charAt(i))) {
        		windowVowels++;
        	}
        	
            maxVowels = Math.max(windowVowels, maxVowels);
        }
        
        return maxVowels;
    }
}