class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int distance = Integer.MAX_VALUE;
        
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1))
                i1 = i;
            if (wordsDict[i].equals(word2))
                i2 = i;
            if (i1 != -1 && i2 != -1)
                distance = Math.min(distance, Math.abs(i2 - i1));
        }
        
        return distance;
    }
}