class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(a[1], b[1]));
        int i = boxTypes.length - 1;
        int result = 0;
        
        while (i >= 0 && truckSize > 0) {
            if (truckSize >= boxTypes[i][0]) {
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
                i--;
            } else {
                result += truckSize * boxTypes[i][1];
                break;
            }
        }
        
        return result;
    }
}