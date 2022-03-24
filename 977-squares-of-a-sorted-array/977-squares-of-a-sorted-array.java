class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;
        
        while (start <= end) {
            int startSqr = nums[start] * nums[start];
            int endSqr = nums[end] * nums[end];
            
            if (startSqr < endSqr) {
                result[index] = endSqr;
                end--;
            } else {
                result[index] = startSqr;
                start++;
            }
            index--;
        }
        
        return result;
    }
}