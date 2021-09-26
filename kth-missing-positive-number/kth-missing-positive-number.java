class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int num : arr)
            set.add(num);
        
        for (int i = 1; i <= arr.length + k; i++)
            if (!set.contains(i))
                list.add(i);
        
        return list.get(k - 1);
    }
}