class Solution {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int index = 0;
        groups[0] = 1;
        int result = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i))
                groups[++index] = 1;
            else
                groups[index]++;
        }
        
        for (int i = 1; i <= index; i++)
            result += Math.min(groups[i - 1], groups[i]);
        
        return result;
    }
}