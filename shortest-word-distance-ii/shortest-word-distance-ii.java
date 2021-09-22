class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> location = this.map.getOrDefault(wordsDict[i], new ArrayList<Integer>());
            location.add(i);
            this.map.put(wordsDict[i], location);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> location1, location2;
        location1 = this.map.get(word1);
        location2 = this.map.get(word2);
        
        int distance = Integer.MAX_VALUE;
        int index1 = 0, index2 = 0;
        
        while (index1 < location1.size() && index2 < location2.size()) {
            distance = Math.min(distance, Math.abs(location1.get(index1) - location2.get(index2)));
            if (location1.get(index1) < location2.get(index2))
                index1++;
            else 
                index2++;
        }
        
        return distance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */