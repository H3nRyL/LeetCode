class Solution {
    public int fib(int n) {
        return fib(n, 0, 1);
    }
    
    private int fib(int n, int a, int b) {
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        return fib(n - 1, b, a + b);
    }
}