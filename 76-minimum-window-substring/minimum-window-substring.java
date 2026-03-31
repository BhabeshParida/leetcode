class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128]; // ASCII

        // Step 1: store frequency of t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0;
        int count = t.length(); // total chars needed

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            // If char is useful
            if (freq[r] > 0) {
                count--;
            }
            freq[r]--;

            // When all chars are matched
            while (count == 0) {
                // Update result
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                freq[l]++;

                // If removing breaks requirement
                if (freq[l] > 0) {
                    count++;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE 
            ? "" 
            : s.substring(start, start + minLen);
    }
}