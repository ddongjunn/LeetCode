class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        StringBuilder left = new StringBuilder();
        char middle = 0;
        for (int i = 0; i < count.length; i++) {
            char ch = (char) ('a' + i);
            left.append(String.valueOf(ch).repeat(count[i] / 2));

            if (count[i] % 2 == 1) {
                middle = ch;
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return middle == 0
            ? left.toString() + right
            : left.toString() + middle + right;
    }
}