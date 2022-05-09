class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        
        return heap.poll();
    }
}