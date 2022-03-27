class Solution {
    public int tribonacci(int n) {
        int[] tri = new int[38];
        tri[0] = 0;
        tri[1] = 1;
        tri[2] = 1;
        for (int i = 3; i < 38; i++) 
            tri[i] = tri[i - 1] + tri[i - 2] + tri[i - 3];
        
        return tri[n];
    }
}