class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int direction = 1;
        
        for (int i = 0; i < instructions.length(); i++) {
            char curr = instructions.charAt(i);
            if (curr == 'L') 
                direction = (direction == 1) ? 4 : direction - 1;
            else if (curr == 'R')
                direction = (direction == 4) ? 1 : direction + 1;
            else {
                switch (direction) {
                    case 1:
                        y++;
                        break;
                    case 2:
                        x++;
                        break;
                    case 3:
                        y--;
                        break;
                    case 4:
                        x--;
                        break;
                }
            }
        }
        
        return (x == 0 && y == 0) || direction != 1; 
    }
}