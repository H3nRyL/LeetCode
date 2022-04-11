class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int first = 0;
        int second = 0;
        List<int[]> result = new ArrayList<>();
        
        while (first < firstList.length && second < secondList.length) {
            int lo = Math.max(firstList[first][0], secondList[second][0]);
            int hi = Math.min(firstList[first][1], secondList[second][1]);
            
            if (lo <= hi)
                result.add(new int[]{lo, hi});
            
            if (firstList[first][1] < secondList[second][1])
                first++;
            else
                second++;
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}