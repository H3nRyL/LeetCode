class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        int result = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar))
                currentNum = currentNum * 10 + currentChar - '0';
            else if (currentChar == '+') {
                result += sign * currentNum;
                sign = 1;
                currentNum = 0;
            } else if (currentChar == '-') {
                result += sign * currentNum;
                sign = -1;
                currentNum = 0;
            } else if (currentChar == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (currentChar == ')') {
                result += sign * currentNum;
                result *= stack.pop();
                result += stack.pop();
                currentNum = 0;
            }
        }
        
        return result + sign * currentNum;
    }
}