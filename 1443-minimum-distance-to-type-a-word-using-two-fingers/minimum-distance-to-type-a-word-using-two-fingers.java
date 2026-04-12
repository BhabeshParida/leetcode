class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[n][26];

        // Initialize DP with large values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // First character → no cost (both fingers free)
        for (int j = 0; j < 26; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';

            for (int j = 0; j < 26; j++) {
                if (dp[i - 1][j] == Integer.MAX_VALUE) continue;

                // Case 1: same finger moves (prev → curr)
                dp[i][j] = Math.min(dp[i][j],
                        dp[i - 1][j] + dist(prev, curr));

                // Case 2: other finger moves (j → curr)
                dp[i][prev] = Math.min(dp[i][prev],
                        dp[i - 1][j] + dist(j, curr));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < 26; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }

    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}