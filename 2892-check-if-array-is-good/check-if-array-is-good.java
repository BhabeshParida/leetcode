class Solution {
    public boolean isGood(int[] nums) {
        
        int n = nums.length;
        
        // Sort the array
        Arrays.sort(nums);
        
        int max = nums[n - 1];
        
        // For a good array:
        // max element must be n-1
        if (max != n - 1) {
            return false;
        }
        
        // Check elements from 1 to max-1
        for (int i = 0; i < n - 2; i++) {
            
            if (nums[i] != i + 1) {
                return false;
            }
        }
        
        // Last two elements should be equal to max
        return nums[n - 2] == max;
    }
}