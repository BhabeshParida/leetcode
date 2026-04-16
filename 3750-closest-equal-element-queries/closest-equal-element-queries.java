import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        // Step 1: Map value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        // Step 2: Process each query
        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);
            
            // If only one occurrence
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }
            
            // Binary search to find current index position
            int pos = Collections.binarySearch(list, idx);
            
            int m = list.size();
            
            // Get neighbors (circular in list)
            int left = list.get((pos - 1 + m) % m);
            int right = list.get((pos + 1) % m);
            
            // Compute circular distances
            int distLeft = Math.min(Math.abs(idx - left), n - Math.abs(idx - left));
            int distRight = Math.min(Math.abs(idx - right), n - Math.abs(idx - right));
            
            ans.add(Math.min(distLeft, distRight));
        }
        
        return ans;
    }
}