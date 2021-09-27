class Solution {
    public int minOperations(String s) {
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) 
            if (s.charAt(i) - '0' != i % 2)
                result++;
        
        return Math.min(result, s.length() - result);
    }
}