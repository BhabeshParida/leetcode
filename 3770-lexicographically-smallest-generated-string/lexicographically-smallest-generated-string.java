import java.util.*;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] res = new char[n + m - 1];
        Arrays.fill(res, '?'); // initially unknown

        // Step 1: Apply all 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != '?' && res[i + j] != str2.charAt(j)) {
                        return ""; // conflict
                    }
                    res[i + j] = str2.charAt(j);
                }
            }
        }

        // Step 2: Fill remaining '?' with 'a' (smallest lexicographically)
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '?') res[i] = 'a';
        }

        // Step 3: Handle 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;

                // Check if substring equals str2
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If equal → must break it
                if (match) {
                    boolean changed = false;

                    // Try changing from right to left
                    for (int j = m - 1; j >= 0; j--) {
                        char original = res[i + j];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != str2.charAt(j)) {
                                res[i + j] = c;

                                // Check that no 'T' condition is broken
                                boolean valid = true;
                                for (int x = Math.max(0, i + j - m + 1); x <= Math.min(n - 1, i + j); x++) {
                                    if (str1.charAt(x) == 'T') {
                                        for (int y = 0; y < m; y++) {
                                            if (res[x + y] != str2.charAt(y)) {
                                                valid = false;
                                                break;
                                            }
                                        }
                                        if (!valid) break;
                                    }
                                }

                                if (valid) {
                                    changed = true;
                                    break;
                                } else {
                                    res[i + j] = original; // revert
                                }
                            }
                        }

                        if (changed) break;
                    }

                    if (!changed) return "";
                }
            }
        }

        return new String(res);
    }
}