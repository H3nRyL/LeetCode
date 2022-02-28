class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        
        int result = 0;
        int index = 0;
        
        while (truckSize > 0 && index < boxTypes.length) {
            if (boxTypes[index][0] <= truckSize) {
                result += boxTypes[index][0] * boxTypes[index][1];
                truckSize -= boxTypes[index][0];
                index++;
            } else {
                result += truckSize * boxTypes[index][1];
                break;
            }
        }
        
        return result;
    }
}