class Solution {
    int[] fibo = new int[31];
    
    public Solution() {
        fibo[0] = 0;
        fibo[1] = 1;
    }
    
    public int fib(int n) {
        if(n < 1) {
            return 0;
        }
        
        if(fibo[n] != 0) {
            return fibo[n];
        }
        
        return fib(n - 1) + fib(n - 2);
    }
}