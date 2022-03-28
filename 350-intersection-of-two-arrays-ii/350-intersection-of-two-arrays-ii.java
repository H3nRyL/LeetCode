class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        int k = 0;
        for (int j : nums2) {
            int count = map.getOrDefault(j, 0);
            if (count > 0) {
                nums1[k++] = j;
                map.put(j, count - 1);
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
}