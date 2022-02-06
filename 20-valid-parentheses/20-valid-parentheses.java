class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!stack.isEmpty()) {
                if (map.containsKey(c) && map.get(c).equals(stack.peek())) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        
        return stack.isEmpty();
    } 
}