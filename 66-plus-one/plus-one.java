class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;   // just add 1
                return digits; // no carry needed
            }
            digits[i] = 0;     // if 9 → make it 0 and carry continues
        }

        // If all digits were 9 (e.g., 999 → 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}