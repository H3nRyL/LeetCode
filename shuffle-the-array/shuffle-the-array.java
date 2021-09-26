class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                result[i] = nums[i / 2];
            else
                result[i] = nums[i / 2 + n];
        }
        
        return result;
    }
}