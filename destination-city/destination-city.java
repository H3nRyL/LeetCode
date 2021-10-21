class Solution {
    public String destCity(List<List<String>> paths) {
        List<String> start = new ArrayList<>();
        List<String> end = new ArrayList<>();
        
        for (List<String> list : paths) {
            start.add(list.get(0));
            end.add(list.get(1));
        }
        
        for (String str : end)
            if (!start.contains(str))
                return str;
        
        return "";
    }
}