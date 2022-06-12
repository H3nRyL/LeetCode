class Solution {
    
    private int[] prefixSums;
    private int totalSum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        
        int prefixSum = 0;
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        
        this.totalSum = prefixSum;
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        
        int lo = 0;
        int hi = this.prefixSums.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > this.prefixSums[mid])
                lo = mid + 1;
            else 
                hi = mid;
        }
        
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */