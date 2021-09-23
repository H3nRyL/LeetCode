class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0)
            return n <= 1;
        if (flowerbed.length == 1 && flowerbed[0] == 1)
            return n == 0;
        
        int max = 0;
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0)
                max++;
            else if (i == 0 && flowerbed[0] == 0 && flowerbed[1] == 0) {
                max++;
                i++;
            } else if (i > 0 && i < flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                max++;
                i++;
            }
        }
        
        return max >= n;
    }
}