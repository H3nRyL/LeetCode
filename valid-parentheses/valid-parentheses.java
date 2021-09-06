class Solution {
    private Map<Character, Character> map = new HashMap<>();
    
    public Solution() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (map.containsKey(temp)) {
                char top = stack.empty() ? '#' : stack.pop();
                
                if (top != map.get(temp))
                    return false;
                
            } else
                stack.push(temp);
        }
        
        return stack.isEmpty();
    }
}