class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
    
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);
            
        return slow == 1;
    }
    
    public int square(int n){
        int sum = 0;
        while(n != 0){
            sum += (int) Math.pow((n % 10), 2);
            n = n / 10;
        }
        return sum;
    }
}