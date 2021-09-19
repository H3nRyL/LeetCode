class Solution {
    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;
    
    private boolean isPossible;
    private Map<Integer, Integer> color;
    private Map<Integer, List<Integer>> adj;
    List<Integer> topological;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adj = new HashMap<>();
        this.topological = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++)
            this.color.put(i, WHITE);
        
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = adj.getOrDefault(src, new ArrayList<Integer>());
            list.add(dest);
            adj.put(src, list);
        }
        
        for (int i = 0; i < numCourses; i++) 
            if (this.color.get(i) == WHITE)
                dfs(i);
        
        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++)
                order[i] = this.topological.get(numCourses - 1 - i);
        } else 
            order = new int[0];
        
        return order;
    }
    
    private void dfs(int node) {
        if (!this.isPossible)
            return;
        
        this.color.put(node, GRAY);
        
        for (Integer neighbor : this.adj.getOrDefault(node, new ArrayList<Integer>())) {
            if (this.color.get(neighbor) == WHITE)
                dfs(neighbor);
            else if (this.color.get(neighbor) == GRAY)
                this.isPossible = false;
        }
        
        this.color.put(node, BLACK);
        this.topological.add(node);
    }
}