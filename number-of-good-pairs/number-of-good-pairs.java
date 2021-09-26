class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int[] count = new int[101];
        
        for (int n : nums)
            count[n]++;
        
        for (int n : count)
            result += n * (n - 1) / 2;
        
        return result;
    }
}