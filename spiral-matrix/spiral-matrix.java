class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowStart = 0, columnStart = 0;
        int rowMax = matrix.length;
        int columnMax = matrix[0].length;
        int size = rowMax * columnMax;
        int direction = 0;
        
        while (result.size() < size) {
            switch (direction) {
                case 0 :
                    for (int i = columnStart; i < columnMax; i++)
                        result.add(matrix[rowStart][i]);
                    rowStart++;
                    direction = 1;
                    break;
                
                case 1:
                    for (int i = rowStart; i < rowMax; i++)
                        result.add(matrix[i][columnMax - 1]);
                    columnMax--;
                    direction = 2;
                    break;
                
                case 2:
                    for (int i = columnMax - 1; i >= columnStart; i--)
                        result.add(matrix[rowMax - 1][i]);
                    rowMax--;
                    direction = 3;
                    break;
                
                case 3:
                    for (int i = rowMax - 1; i >= rowStart; i--)
                        result.add(matrix[i][columnStart]);
                    columnStart++;
                    direction = 0;
                    break;
            }
        }
        
        return result;
    }
}