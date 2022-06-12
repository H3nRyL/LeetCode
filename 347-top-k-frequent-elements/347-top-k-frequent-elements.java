class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums)
            count.put(i, count.getOrDefault(i, 0) + 1);
        
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        
        for (int i : count.keySet()) {
            heap.add(i);
            if (heap.size() > k)
                heap.poll();
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k ; i++)
            result[i] = heap.poll();
        
        return result;
    }
}