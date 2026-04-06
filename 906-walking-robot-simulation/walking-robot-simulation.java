import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // Directions: North, East, South, West
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int d = 0; // start facing North
        
        int x = 0, y = 0;
        int maxDist = 0;

        // Store obstacles in HashSet
        Set<String> set = new HashSet<>();
        for (int[] ob : obstacles) {
            set.add(ob[0] + "," + ob[1]);
        }

        for (int cmd : commands) {
            
            if (cmd == -1) { // turn right
                d = (d + 1) % 4;
            } 
            else if (cmd == -2) { // turn left
                d = (d + 3) % 4;
            } 
            else {
                // move step by step
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    // check obstacle
                    if (set.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}