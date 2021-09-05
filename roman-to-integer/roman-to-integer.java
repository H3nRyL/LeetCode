class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50, 'X', 10, 'V', 5, 'I', 1);
        int total = 0;
        int i = 0;
        
        while (i < s.length()) {
            char current = s.charAt(i);
            int currentValue = map.get(current);
            int nextValue = 0;
            
            if (i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                nextValue = map.get(next);
            }
            
            if (currentValue < nextValue) {
                total += (nextValue - currentValue);
                i += 2;
            } else {
                total += currentValue;
                i += 1;
            }
        }
        
        return total;
    }
}