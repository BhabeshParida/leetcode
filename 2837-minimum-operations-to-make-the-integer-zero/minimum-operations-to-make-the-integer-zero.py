class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for k in range(1, 61):
            remaining = num1 - k * num2
            
            # If remaining becomes negative, no need to continue
            if remaining < 0:
                break
            
            # remaining must be representable as sum of k powers of 2
            # popcount(remaining) <= k and remaining >= k
            if bin(remaining).count('1') <= k and remaining >= k:
                return k
        
        return -1
