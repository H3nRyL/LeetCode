class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            char currentSymbol = s.charAt(i);
            int currentValue = map.get(currentSymbol);
            int nextValue = 0;
            
            if (i + 1 < s.length()) {
                char nextSymbol = s.charAt(i + 1);
                nextValue = map.get(nextSymbol);
            }
            
            if (currentValue < nextValue) {
                sum += nextValue - currentValue;
                i += 2;
            } else {
                sum += currentValue;
                i++;
            }
        }
        
        return sum;
    }
}