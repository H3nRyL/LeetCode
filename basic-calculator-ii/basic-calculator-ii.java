class Solution {
    public int calculate(String s) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                string.append(s.charAt(i));
        }
        String str = string.toString();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*' || str.charAt(i) == '/') {
                char operator = str.charAt(i);
                int base = 1;
                int num1 = 0;
                
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num1 = num1 + (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                StringBuilder sb = new StringBuilder();
                while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                    sb.append(str.charAt(i + 1));
                    i++;
                }
                
                int num2 = Integer.parseInt(sb.toString());
                String result;
                if (operator == '*')
                    result = String.valueOf(num1 * num2);
                else
                    result = String.valueOf(num1 / num2);
                
                for (int j = 0; j < result.length(); j++) 
                    stack.push(result.charAt(j));
            } else
                stack.push(str.charAt(i));
        }
        
        char[] temp = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            temp[i] = stack.pop();
            System.out.println(temp[i]);
        }
        
        StringBuilder first = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if (Character.isDigit(temp[i]))
                first.append(temp[i]);
            else
                break;
        }
        
        System.out.println(first.toString() + '!');
        int result = Integer.parseInt(first.toString());
        
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '+' || temp[i] == '-') {
                char operator = temp[i];
                StringBuilder sb = new StringBuilder();
                while (i + 1 < temp.length && Character.isDigit(temp[i + 1])) {
                    sb.append(temp[i + 1]);
                    i++;
                }
                int num = Integer.parseInt(sb.toString());
                if (operator == '+')
                    result += num;
                else
                    result -= num;
            }
        }
        
        return result;
    }
}