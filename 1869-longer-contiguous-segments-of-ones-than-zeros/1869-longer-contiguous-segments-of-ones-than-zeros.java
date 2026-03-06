class Solution {
    public boolean checkZeroOnes(String s) {
        int currentOne = 0;
        int currentZero = 0;

        int maxOne = 0;
        int maxZero = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '1') {
                currentOne++;
                currentZero = 0;
                maxOne = Math.max(maxOne, currentOne);
            } else {
                currentZero++;
                currentOne = 0;
                maxZero = Math.max(maxZero, currentZero);
            }
        }

        return maxOne > maxZero;
    }
}