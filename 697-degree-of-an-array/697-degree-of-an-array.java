class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int result = 0, degree = 0;
        
        for (int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                result = i - first.get(nums[i]) + 1;
            } else if (count.get(nums[i]) == degree)
                result = Math.min(result, i - first.get(nums[i]) + 1);
        }
        
        return result;
    }
}