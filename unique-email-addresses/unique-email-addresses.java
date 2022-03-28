class Solution {
    public int numUniqueEmails(String[] emails) {
        for (int i = 0; i < emails.length; i++) {
            String localName = emails[i].split("@")[0];
            String domainName = emails[i].split("@")[1];
            
            String valid = localName.split("\\+")[0].replaceAll("\\.", "");
            emails[i] = valid + "@" + domainName;
        }
        
        Set<String> set = new HashSet<>();
        int result = 0;
        for (String s : emails) {
            if (!set.contains(s))
                result++;
            set.add(s);
        }
        
        return result;
    }
}