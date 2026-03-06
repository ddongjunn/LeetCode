class Solution {
    public boolean checkZeroOnes(String s) {
        int maxLength0 = 0;
        int maxLength1 = 0;
        int count0 = 0;
        int count1 = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
                maxLength0 = Math.max(count0, maxLength0);
                count0 = 0;
            }

            if (c == '0') {
                count0++;
                maxLength1 = Math.max(count1, maxLength1);
                count1 = 0;
            }
        }
        maxLength0 = Math.max(count0, maxLength0);
        maxLength1 = Math.max(count1, maxLength1);
        return maxLength1 > maxLength0;
    }
}