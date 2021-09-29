class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (map.containsKey(temp)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                
                if (top != map.get(temp))
                    return false;
            } else {
                stack.push(temp);
            }
        }
        
        return stack.isEmpty();
    }
}