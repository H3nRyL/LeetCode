class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    markIsland(grid, i, j);
                }    
            }
        }
        
        return result;
    }
    
    private void markIsland(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        markIsland(grid, r - 1, c);
        markIsland(grid, r + 1, c);
        markIsland(grid, r, c - 1);
        markIsland(grid, r, c + 1);
    }
}