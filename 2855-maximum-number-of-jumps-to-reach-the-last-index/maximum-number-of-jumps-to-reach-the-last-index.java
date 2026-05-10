class Solution {
    public int maximumJumps(int[] nums, int target) {
        
        int n = nums.length;
        
        // dp[i] = maximum jumps to reach index i
        int[] dp = new int[n];
        
        // Initialize all as unreachable
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            
            // If current index is unreachable
            if (dp[i] == -1) {
                continue;
            }
            
            for (int j = i + 1; j < n; j++) {
                
                long diff = (long) nums[j] - nums[i];
                
                // Check jump condition
                if (diff >= -target && diff <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}