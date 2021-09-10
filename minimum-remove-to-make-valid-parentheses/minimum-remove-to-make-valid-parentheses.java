class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> remove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            if (s.charAt(i) == ')') {
                if (stack.isEmpty())
                    remove.add(i);
                else
                    stack.pop();
            }
        }
        
        while (!stack.isEmpty())
            remove.add(stack.pop());
        
        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i))
                sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}