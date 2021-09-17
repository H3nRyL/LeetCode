class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return result;
        if (k == 2)
            return twoSum(nums, target, start);
        
        for (int i = start; i < nums.length; i++)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(subset);
                }
        
        return result;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        
        for (int i = start; i < nums.length; i++) {
            if (result.isEmpty() || result.get(result.size() - 1).get(1) != nums[i]) 
                if (s.contains(target - nums[i]))
                    result.add(Arrays.asList(target - nums[i], nums[i]));
            s.add(nums[i]);
        }
        
        return result;
    }
}