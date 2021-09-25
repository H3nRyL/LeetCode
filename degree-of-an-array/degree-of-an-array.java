class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if (!left.containsKey(nums[i]))
                left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        int result = Integer.MAX_VALUE;
        int degree = Collections.max(count.values());
        
        for (int num : nums) 
            if (count.get(num) == degree)
                result = Math.min(result, right.get(num) - left.get(num) + 1);
        
        return result;
    }
}