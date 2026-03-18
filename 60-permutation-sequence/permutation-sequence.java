class Solution {
    public String getPermutation(int n, int k) {
        
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        
        // Build numbers list and factorial
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            if (i < n) fact *= i;  // (n-1)!
        }
        
        // Convert to 0-based index
        k = k - 1;
        
        StringBuilder res = new StringBuilder();
        
        while (nums.size() > 0) {
            int index = k / fact;
            res.append(nums.get(index));
            nums.remove(index);
            
            if (nums.size() == 0) break;
            
            k = k % fact;
            fact = fact / nums.size();
        }
        
        return res.toString();
    }
}