class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < cpdomains.length; i++) {
            String[] str = cpdomains[i].split(" ");
            int visit = Integer.parseInt(str[0]);
            map.put(str[1], map.getOrDefault(str[1], 0) + visit);
            
            for (int j = 0; j < str[1].length(); j++) {
                if (str[1].charAt(j) == '.') {
                    String domain = str[1].substring(j + 1);
                    System.out.println(domain);
                    map.put(domain, map.getOrDefault(domain, 0) + visit);
                }
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String res = String.valueOf(entry.getValue()) + " " + entry.getKey();
            result.add(res);
        }
        
        return result;
    }
}