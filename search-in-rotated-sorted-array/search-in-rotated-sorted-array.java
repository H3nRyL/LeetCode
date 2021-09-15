class Solution {
    private int[] nums;
    private int target;
    
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        
        if (n == 1) 
            return this.nums[0] == target ? 0 : -1;
        
        int rotate = findRotate(0, n - 1);
        
        if (nums[rotate] == target)
            return rotate;
        if (rotate == 0)
            return search(0, n - 1);
        if (target < nums[0])
            return search(rotate, n - 1);
        return search(0, rotate);
    }
    
    private int findRotate(int left, int right) {
        if (nums[left] < nums[right])
            return 0;
        
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        
        return 0;
    }
    
    private int search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else 
                    left  = pivot + 1;
            }
        }
        
        return -1;
    }
}