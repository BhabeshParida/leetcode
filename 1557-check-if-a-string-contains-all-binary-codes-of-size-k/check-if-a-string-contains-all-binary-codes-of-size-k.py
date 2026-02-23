class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        # If string length is smaller than k, impossible
        if len(s) < k:
            return False
        
        seen = set()
        
        # Collect all substrings of length k
        for i in range(len(s) - k + 1):
            seen.add(s[i:i+k])
        
        # Total possible binary codes of length k = 2^k
        return len(seen) == (1 << k)