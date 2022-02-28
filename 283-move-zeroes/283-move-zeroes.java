class Solution {
    public void moveZeroes(int[] nums) {
        int current = 0;
        
        for (int num : nums)
            if (num != 0)
                nums[current++] = num;
        
        for (int i = current; i < nums.length; i++)
            nums[i] = 0;
    }
}