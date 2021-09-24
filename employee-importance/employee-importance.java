/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private Map<Integer, Employee> map;
    
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        
        for (Employee e : employees) 
            map.put(e.id, e);
        
        return dfs(id);
    }
    
    private int dfs(int id) {
        Employee e = map.get(id);
        int ans = e.importance;
        
        for (Integer subid : e.subordinates)
            ans += dfs(subid);
            
        return ans;
    }
}