class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String localName = emails[i].split("@")[0];
            String domainName = emails[i].split("@")[1];
            
            String valid = localName.split("\\+")[0].replaceAll("\\.", "");
            emails[i] = valid + "@" + domainName;
            set.add(emails[i]);
        }
        
        return set.size();
    }
}