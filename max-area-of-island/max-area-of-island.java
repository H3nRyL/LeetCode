class Solution {
    private int[][] grid;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int result = 0;
        
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                result = Math.max(result, area(r, c));
        
        return result;
    }
    
    private int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        return 1 + area(r + 1, c) + area(r - 1, c) + area(r, c + 1) + area(r, c - 1);
    }
}