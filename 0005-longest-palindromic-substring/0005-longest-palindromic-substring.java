class Solution {
    int left = 0;
    int max = Integer.MIN_VALUE;
    
    public String longestPalindrome(String s) { 
        if(s.length() < 2) {
            return s.substring(0, 1);
        }
        
        for(int i = 0; i < s.length(); i++) {
            palindrome(s, i, i + 1);
            palindrome(s, i, i + 2);
        }        
        return s.substring(left, left + max);
    }
    
    public void palindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        if(max < end - start - 1) {
            left = start + 1;
            max = end - start - 1;
        }
    }
}