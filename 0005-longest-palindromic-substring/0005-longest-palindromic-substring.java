class Solution {
    int left, right;
    
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if(s.length() < 2){
            return s;
        }
        
        for(int i = 0; i < chars.length; i++){
            expendPalindrome(chars, i, i);
            expendPalindrome(chars, i, i + 1);
        }
        
        return s.substring(left, left + right);
    }
    
    public void expendPalindrome(char[] chars, int i, int j){
        while(i >= 0 && j < chars.length && chars[i] == chars[j]){
            i--;
            j++;
        }
        
        if(right < j - i - 1){
            left = i + 1;
            right = j - i - 1;
        }
    }
}