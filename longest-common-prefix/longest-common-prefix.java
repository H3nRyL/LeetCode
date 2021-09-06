class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int shortest = strs[0].length();
        
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortest)
                shortest = strs[i].length();
        }
        
        for (int i = 0; i < shortest; i++) {
            char temp = strs[0].charAt(i);
            int j = 1;
            
            while (j < strs.length) {
                if (strs[j].charAt(i) != temp)
                    return sb.toString();
                j++;
            }
            
            sb.append(temp);
        }
        
        return sb.toString();
    }
}