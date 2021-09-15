class Solution {
    private Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private List<String> result = new ArrayList<>();
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return result;
        
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return result;       
    }
    
    private void backtrack(int index, StringBuilder path) {
        if (path.length() == phoneDigits.length()) {
            result.add(path.toString());
            return;
        }
        
        String possible = map.get(phoneDigits.charAt(index));
        for (char letter : possible.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() - 1); 
        }
    }
}