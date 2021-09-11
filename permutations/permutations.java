class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums) 
            list.add(num);
        
        backtrack(nums.length, list, result, 0);
        return result;
    }
    
    private void backtrack(int n, List<Integer> nums, List<List<Integer>> result, int first) {
        if (first == n)
            result.add(new ArrayList<Integer>(nums));
        
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, result, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}