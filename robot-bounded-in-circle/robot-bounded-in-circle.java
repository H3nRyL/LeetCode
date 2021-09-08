class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int direction = 0;
        
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                if (direction == 3)
                    direction = 0;
                else
                    direction++;
            } else if (instructions.charAt(i) == 'R') {
                if (direction == 0)
                    direction = 3;
                else
                    direction--;
            } else {
                switch (direction) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x--;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x++;
                        break;
                }
            }
        }
        
        if (direction == 0) {
            if (x != 0 || y != 0)
                return false;      
        } 
        
        return true;
    }
}