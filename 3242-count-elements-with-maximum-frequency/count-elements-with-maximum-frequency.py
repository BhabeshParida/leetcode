from typing import List
from collections import Counter

class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq = Counter(nums)
        max_freq = max(freq.values())

        total = 0
        for count in freq.values():
            if count == max_freq:
                total += count

        return total
