class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        
        // Step 1: Initialize with '?'
        for (int i = 0; i < n; i++) {
            word[i] = '?';
        }
        
        char ch = 'a';
        
        // Step 2: Build the string (group equal indices)
        for (int i = 0; i < n; i++) {
            if (word[i] == '?') {
                if (ch > 'z') return ""; // more than 26 groups
                
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = ch;
                    }
                }
                ch++;
            }
        }
        
        // Step 3: Validate by recomputing LCP
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    if (i == n - 1 || j == n - 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        // Step 4: Compare matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }
        
        return new String(word);
    }
}
