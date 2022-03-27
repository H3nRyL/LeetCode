class Solution {
    public int tribonacci(int n) {
        int first = 0;
        int second = 1;
        int third = 1;
        if (n < 2)
            return n;
        if (n == 2)
            return 1;
        int result = 0;
        while (n > 2) {
            result = first + second + third;
            first = second;
            second = third;
            third = result;
            n--;
        }
        
        return result;
    }
}