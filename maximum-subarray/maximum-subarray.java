class Solution {
    public int maxSubArray(int[] nums) {
        int currentArray = nums[0];
        int maxSubArray = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentArray = Math.max(nums[i], currentArray + nums[i]);
            maxSubArray = Math.max(maxSubArray, currentArray);
        }
        
        return maxSubArray;
    }
}