class Solution {
    public int numSpecial(int[][] mat) {
        
        int m = mat.length;      // number of rows
        int n = mat[0].length;   // number of columns
        
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        // Step 1: Count number of 1s in each row and column
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int specialCount = 0;
        
        // Step 2: Check for special positions
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    specialCount++;
                }
            }
        }
        
        return specialCount;
    }
}