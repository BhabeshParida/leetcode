class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailing = new int[n];

        // Step 1: Count trailing zeros in each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailing[i] = count;
        }

        int swaps = 0;

        // Step 2: Try to place correct row at each position
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int j = i;

            // Find a row below with enough trailing zeros
            while (j < n && trailing[j] < required) {
                j++;
            }

            // If not found, impossible
            if (j == n) {
                return -1;
            }

            // Bring row j up to position i using adjacent swaps
            while (j > i) {
                int temp = trailing[j];
                trailing[j] = trailing[j - 1];
                trailing[j - 1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}