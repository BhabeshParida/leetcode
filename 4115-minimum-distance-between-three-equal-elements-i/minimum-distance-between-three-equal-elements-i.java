import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        
        // Store indices for each number
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        // Check each list of indices
        for (ArrayList<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int first = list.get(i);
                    int third = list.get(i + 2);
                    
                    // distance = 2 * (k - i)
                    int dist = 2 * (third - first);
                    minDist = Math.min(minDist, dist);
                }
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}