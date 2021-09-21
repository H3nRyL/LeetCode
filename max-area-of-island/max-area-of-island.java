class Solution {
    private int[][] grid;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int result = 0;
        
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                result = Math.max(result, dfs(r, c));
        
        return result;
    }
    
    private int dfs(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        return 1 + dfs(r + 1, c) + dfs(r - 1, c) + dfs(r, c + 1) + dfs(r, c - 1);
    }
}