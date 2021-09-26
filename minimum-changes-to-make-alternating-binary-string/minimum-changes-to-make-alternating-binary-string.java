class Solution {
    public int minOperations(String s) {
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' != i % 2)
                result++;
        }
        
        return Math.min(result, n - result);
    }
}