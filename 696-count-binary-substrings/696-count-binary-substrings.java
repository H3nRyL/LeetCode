class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0, prev = 0, curr = 1;
        
        for (int i = 1; i< s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                result += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            } else
                curr++;
        }
        
        return result + Math.min(prev, curr);
    }
}