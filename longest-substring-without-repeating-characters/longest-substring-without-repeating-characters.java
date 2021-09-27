class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int result = 0;
        int left = 0; 
        int right = 0;
        
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            
            result = Math.max(result, right - left + 1);
            right++;
        }
        
        return result;
    }
}