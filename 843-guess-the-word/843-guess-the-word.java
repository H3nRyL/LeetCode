/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random rand = new Random();
        for (int i = 0, matches = 0; i < 10 && matches != 6; i++) {
            String guess = wordlist[rand.nextInt(wordlist.length)];
            matches = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for (String word : wordlist) {
                if (matches == getMatches(guess, word))
                    candidates.add(word);
            }
            
            wordlist = candidates.toArray(new String[0]);
        }  
    }
    
    private int getMatches(String word1, String word2) {
            int match = 0;
            
            for (int i = 0; i < 6; i++) {
                if (word1.charAt(i) == word2.charAt(i))
                    match++;
            }
            
            return match;
        }
}