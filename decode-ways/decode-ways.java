class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int numDecodings(String s) {
        return recursiveWithMemo(0, s); 
    }
    
    private int recursiveWithMemo(int index, String str) {
        if (map.containsKey(index)) 
            return map.get(index);
        
        if (index == str.length())
            return 1;
        
        if (str.charAt(index) == '0')
           return 0;
            
        if (index == str.length() - 1)
            return 1;
            
        int result = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26)
            result += recursiveWithMemo(index + 2, str);
            
        map.put(index, result);
        return result;
    }
}