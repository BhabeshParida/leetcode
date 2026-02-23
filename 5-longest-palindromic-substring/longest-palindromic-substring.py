class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        if len(s) < 2:
            return s
        
        start = 0
        max_len = 1
        
        def expand(left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return right - left - 1
        
        for i in range(len(s)):
            
            # Odd length palindrome
            len1 = expand(i, i)
            
            # Even length palindrome
            len2 = expand(i, i + 1)
            
            curr_len = max(len1, len2)
            
            if curr_len > max_len:
                max_len = curr_len
                start = i - (curr_len - 1) // 2
        
        return s[start:start + max_len]