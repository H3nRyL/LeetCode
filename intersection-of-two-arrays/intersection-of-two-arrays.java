class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);
        
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }            
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}