class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int num : nums) {
            // Allow first 2 elements OR if current element is different
            if (i < 2 || num != nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }

        return i;
    }
}