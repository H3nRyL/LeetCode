class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (validSubPalindrome(s, left + 1, right))
                    return true;
                return validSubPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    private boolean validSubPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}