import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates); // sort to handle duplicates
        
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void backtrack(int[] arr, int target, int start,
                           List<Integer> temp, List<List<Integer>> result) {
        
        // Base case
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            
            // Skip duplicates
            if (i > start && arr[i] == arr[i - 1]) continue;
            
            // Stop if current element exceeds target
            if (arr[i] > target) break;
            
            // Choose
            temp.add(arr[i]);
            
            // Explore (move forward, no reuse)
            backtrack(arr, target - arr[i], i + 1, temp, result);
            
            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}