class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        
        int original = x;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        
        return rev == original;
    }
}