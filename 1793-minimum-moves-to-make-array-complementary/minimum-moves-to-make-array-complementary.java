class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;

        // Difference array
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = nums[i];
            int b = nums[n - 1 - i];

            int min = Math.min(a, b);
            int max = Math.max(a, b);

            int sum = a + b;

            // Every sum initially requires 2 moves
            diff[2] += 2;

            // Range where only 1 move is needed
            diff[min + 1] -= 1;
            diff[max + limit + 1] += 1;

            // Exact sum needs 0 moves
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;
        int curr = 0;

        // Calculate minimum moves for all possible sums
        for (int s = 2; s <= 2 * limit; s++) {
            curr += diff[s];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}