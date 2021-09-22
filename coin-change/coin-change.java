class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        return coinChange(coins, amount, new int[amount]);
    }
    
    private int coinChange(int[] coins, int remain, int[] count) {
        if (remain < 0)
            return -1;
        
        if (remain == 0)
            return 0;
        
        if (count[remain - 1] != 0)
            return count[remain - 1];
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, remain - coin, count);
            if (res >= 0 && res < min)
                min = res + 1;
        }
        
        count[remain - 1] = min == Integer.MAX_VALUE ? -1 : min;
        
        return count[remain - 1];
    }
}