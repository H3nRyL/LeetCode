class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        
        Map<String, List> result = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!result.containsKey(key))
                result.put(key, new ArrayList<>());
            result.get(key).add(s);
        }
        
        return new ArrayList(result.values());
    }
}