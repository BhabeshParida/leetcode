class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        // starting cell
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // obstacle blocks path
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // left + top
                }
            }
        }

        return dp[n - 1];
    }
}