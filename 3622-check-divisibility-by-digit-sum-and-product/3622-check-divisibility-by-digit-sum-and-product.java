class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int multiply = 1;
        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            multiply *= digit;
            num /= 10;
        }

        return n % (sum + multiply) == 0;
    }
}