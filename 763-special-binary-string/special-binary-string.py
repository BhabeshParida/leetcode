class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        count = 0
        start = 0
        parts = []
        
        for i, ch in enumerate(s):
            if ch == '1':
                count += 1
            else:
                count -= 1
            
            # When count becomes 0, we found a special substring
            if count == 0:
                # Recursively process inner substring
                inner = self.makeLargestSpecial(s[start+1:i])
                parts.append("1" + inner + "0")
                start = i + 1
        
        # Sort in descending lexicographical order
        parts.sort(reverse=True)
        
        # Join all parts
        return "".join(parts)