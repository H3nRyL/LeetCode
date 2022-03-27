class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        int max1 = robHelper(nums, 0, nums.length - 2);
        int max2 = robHelper(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = t1;
            int current = nums[i];
            t1 = Math.max(current + t2, t1);
            t2 = temp;
        }
        
        return t1;
    }
}