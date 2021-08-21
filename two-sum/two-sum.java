class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2)
            return new int[]{0, 1};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int complent = target - nums[i];
            if (map.containsKey(complent) && map.get(complent) != i)
                return new int[]{i, map.get(complent)};
        }
        throw new IllegalArgumentException("No two sum found!");
    }
}