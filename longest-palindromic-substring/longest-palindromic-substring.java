class Solution {
    private int lo, maxLen;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        
        return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        
        if (maxLen < right - left - 1) {
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }
}