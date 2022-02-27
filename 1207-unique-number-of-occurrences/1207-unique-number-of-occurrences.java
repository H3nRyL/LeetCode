class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int num : arr)
            count.put(num, count.getOrDefault(num, 0) + 1);
        
        Set<Integer> check = new HashSet<>();
        for (int i : count.keySet()) {
            if (check.contains(count.get(i)))
                return false;
            check.add(count.get(i));
        }
        
        return true;
    }
}