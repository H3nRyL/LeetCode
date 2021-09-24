class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            int left = i;
            int right = s.length() - i - 1;
        
            if (s.charAt(left) != s.charAt(right)) {
                if (validPalindrome(s, left + 1, right))
                    return true;
                return validPalindrome(s, left, right - 1);
            }
        }
        
        return true;
    }
    
    private boolean validPalindrome(String s, int low, int high) {
        int n = high - low + 1;
        
        for (int i = 0; i < n / 2; i++) {
            int left = low + i;
            int right = high - i;
            
            if (s.charAt(left) != s.charAt(right))
                return false;
        }
        
        return true;
    }
}